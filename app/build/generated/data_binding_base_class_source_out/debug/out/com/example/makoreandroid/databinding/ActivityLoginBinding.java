// Generated by view binder compiler. Do not edit!
package com.example.makoreandroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.makoreandroid.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final Button loginBtnLogin;

  @NonNull
  public final TextView loginError;

  @NonNull
  public final EditText loginPassword;

  @NonNull
  public final TextView loginRegister;

  @NonNull
  public final EditText loginUserName;

  @NonNull
  public final TextView tvTitle;

  private ActivityLoginBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView imageView4,
      @NonNull LinearLayout linearLayout, @NonNull Button loginBtnLogin,
      @NonNull TextView loginError, @NonNull EditText loginPassword,
      @NonNull TextView loginRegister, @NonNull EditText loginUserName, @NonNull TextView tvTitle) {
    this.rootView = rootView;
    this.imageView4 = imageView4;
    this.linearLayout = linearLayout;
    this.loginBtnLogin = loginBtnLogin;
    this.loginError = loginError;
    this.loginPassword = loginPassword;
    this.loginRegister = loginRegister;
    this.loginUserName = loginUserName;
    this.tvTitle = tvTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageView4;
      ImageView imageView4 = ViewBindings.findChildViewById(rootView, id);
      if (imageView4 == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.login_btnLogin;
      Button loginBtnLogin = ViewBindings.findChildViewById(rootView, id);
      if (loginBtnLogin == null) {
        break missingId;
      }

      id = R.id.login_error;
      TextView loginError = ViewBindings.findChildViewById(rootView, id);
      if (loginError == null) {
        break missingId;
      }

      id = R.id.login_password;
      EditText loginPassword = ViewBindings.findChildViewById(rootView, id);
      if (loginPassword == null) {
        break missingId;
      }

      id = R.id.login_register;
      TextView loginRegister = ViewBindings.findChildViewById(rootView, id);
      if (loginRegister == null) {
        break missingId;
      }

      id = R.id.login_userName;
      EditText loginUserName = ViewBindings.findChildViewById(rootView, id);
      if (loginUserName == null) {
        break missingId;
      }

      id = R.id.tv_title;
      TextView tvTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvTitle == null) {
        break missingId;
      }

      return new ActivityLoginBinding((ConstraintLayout) rootView, imageView4, linearLayout,
          loginBtnLogin, loginError, loginPassword, loginRegister, loginUserName, tvTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
