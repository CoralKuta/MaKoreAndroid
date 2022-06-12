package com.example.makoreandroid.entities;

import com.example.makoreandroid.R;

public class RemoteUser {
    //private int Id;
    final private int avatar = R.drawable.avatar;
    private String NickNam;
    private String UserName;
    private String Server;
    private String lastMessage;
    private String Time;
    //public Conversation Conversation;


    public RemoteUser(String nickNam, String UserName, String lastMessage, String Time, String Server) {
        this.NickNam = nickNam;
        this.UserName = UserName;
        this.Server = Server;
        this.lastMessage = lastMessage;
        this.Time = Time;
    }

    public int getAvatar() {
        return this.avatar;
    }

    public String getTime() {
        return this.Time;
    }

    public String getUserName() {
        return this.UserName;
    }

    public String getNickNam() {
        return this.NickNam;
    }

    public String getLastMessage() {
        return this.lastMessage;
    }

    public String getServer() {
        return this.Server;
    }


}
