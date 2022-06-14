package com.example.makoreandroid.activities;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.room.Room;

import com.example.makoreandroid.R;
import com.example.makoreandroid.adapters.CustomListAdapter;
import com.example.makoreandroid.api.ContactsAPI;
import com.example.makoreandroid.dao.RemoteUserDao;
import com.example.makoreandroid.db.RemoteUserDB;
import com.example.makoreandroid.entities.RemoteUser;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {
    private final String[] displayingError = {"You can't add your self as a user!",
            "This user already exists!",
            "There is no such user!",
            "This server could not be reached",
            "This may take awhile. Please don't Add again",
            "UserName is required!", "Server is required!",
            "This server could not be reach!", "It might take awhile!"};
    private FloatingActionButton addBtn;
    private ListView listView;
    private CustomListAdapter adapter;
    private AlertDialog dialog;
    private ArrayList<RemoteUser> remote;
    private ContactsAPI contactsAPI = new ContactsAPI();
    private TextView error;
    private String UserName;
    private ArrayList<RemoteUser> r = new ArrayList<RemoteUser>();
    private RemoteUserDB db;
    private RemoteUserDao dao;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_contacts_list);

        //take the jwt
        SharedPreferences prefs = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        String token = prefs.getString("token","");


        //add button and onclick listener
        addBtn = findViewById(R.id.hey);
        buildDialog();
        Intent i = getIntent();
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
                String token = prefs.getString("token","");
                dialog.show();
            }
        });

        //actionbar customization
        UserName = i.getStringExtra("UserName");
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);
        TextView title = findViewById(R.id.User_name_title);
        String newTitle = "Welcome " + UserName + "!";
        title.setText(newTitle);

        //Room
        db = Room.databaseBuilder(getApplicationContext(), RemoteUserDB.class,
                "RemoteUserDB").allowMainThreadQueries().build();
        dao = db.remoteUserDao();
        listView = findViewById(R.id.list_view);
        remote = new ArrayList<RemoteUser>(dao.get(UserName));
        adapter = new CustomListAdapter(getApplicationContext(), remote);
        adapter.setAdapter(remote);
        listView.setAdapter(adapter);
        //contacts display and get request from the webAPI

/*
        contactsAPI.get(token, remote, adapter, r, dao, UserName);
        listView.setAdapter(adapter);


 */
        //set every contact clickable and define the onItemClick
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ColorDrawable colorDrawable
                        = new ColorDrawable(Color.alpha(R.color.chat_settings_bar));
                adapterView.getChildAt(i).setBackgroundDrawable(colorDrawable);
                Intent myIntent = getIntent();
                Intent intent = new Intent(getApplicationContext(), ConversationActivity.class);
                intent.putExtra("UserName", myIntent.getStringExtra("UserName"));
                intent.putExtra("friendID", remote.get(i).getId());
                intent.putExtra("friendNickName", remote.get(i).getName());
                intent.putExtra("friendServer", remote.get(i).getServer());
                intent.putExtra("friendAvatar", remote.get(i).getAvatar());
                startActivity(intent);
            }
        });

    }

    private void buildDialog() {
        View view = getLayoutInflater().inflate(R.layout.pop_up, null);
        EditText userName = view.findViewById(R.id.AddUserName);
        EditText NickName = view.findViewById(R.id.AddNickName);
        EditText Server = view.findViewById(R.id.AddServer);
        error = (TextView) view.findViewById(R.id.error);
        dialog = new AlertDialog.Builder(this).setTitle("Add new contact")
                .setPositiveButton("Add", null).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        userName.setText("");
                        NickName.setText("");
                        Server.setText("");
                        error.setText("");
                    }
                }).create();
        dialog.setView(view);
        dialog.setCanceledOnTouchOutside(false);
        userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                error.setText("");
            }
        });
        NickName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                error.setText("");
            }
        });
        Server.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                error.setText("");
            }
        });
        dialog.create();
        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
                String token = prefs.getString("token","");
                if(TextUtils.isEmpty(userName.getText().toString())) {
                    error.setText(displayingError[5]);
                    return;
                }
                if(TextUtils.isEmpty(Server.getText().toString())) {
                    error.setText(displayingError[6]);
                    return;
                }
                contactsAPI.validation(token, userName, Server, error, displayingError, remote,
                        NickName, adapter, ContactActivity.this, dialog, UserName, r, dao);
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        String token = prefs.getString("token","");
        contactsAPI.get(token, remote, adapter, r, dao, UserName);
        listView.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem search = menu.findItem(R.id.action_search);
        SearchView sv = (SearchView)search.getActionView();
        sv.setQueryHint("Search");
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.setAdapter(r);
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        MenuItem settings = menu.findItem(R.id.action_settings);
        settings.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(ContactActivity.this, SettingsActivity.class);
                startActivity(intent);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}