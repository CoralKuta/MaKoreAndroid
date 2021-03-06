// Generated by view binder compiler. Do not edit!
package com.example.makoreandroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.makoreandroid.R;
import com.google.android.material.imageview.ShapeableImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CustomListItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView contactName;

  @NonNull
  public final TextView lastMessage;

  @NonNull
  public final ShapeableImageView profileImage;

  @NonNull
  public final TextView time;

  private CustomListItemBinding(@NonNull LinearLayout rootView, @NonNull TextView contactName,
      @NonNull TextView lastMessage, @NonNull ShapeableImageView profileImage,
      @NonNull TextView time) {
    this.rootView = rootView;
    this.contactName = contactName;
    this.lastMessage = lastMessage;
    this.profileImage = profileImage;
    this.time = time;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CustomListItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CustomListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.custom_list_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CustomListItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.contact_name;
      TextView contactName = ViewBindings.findChildViewById(rootView, id);
      if (contactName == null) {
        break missingId;
      }

      id = R.id.last_message;
      TextView lastMessage = ViewBindings.findChildViewById(rootView, id);
      if (lastMessage == null) {
        break missingId;
      }

      id = R.id.profile_image;
      ShapeableImageView profileImage = ViewBindings.findChildViewById(rootView, id);
      if (profileImage == null) {
        break missingId;
      }

      id = R.id.time;
      TextView time = ViewBindings.findChildViewById(rootView, id);
      if (time == null) {
        break missingId;
      }

      return new CustomListItemBinding((LinearLayout) rootView, contactName, lastMessage,
          profileImage, time);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
