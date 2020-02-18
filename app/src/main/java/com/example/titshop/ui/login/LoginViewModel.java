package com.example.titshop.ui.login;

import android.content.Context;
import android.widget.Toast;

import com.example.titshop.base.BaseViewmodel;

public class LoginViewModel extends BaseViewmodel {
    public void logIn(Context context){
        Toast.makeText(context, "Login", Toast.LENGTH_SHORT).show();
    }

    public void forgot(Context context){
        Toast.makeText(context, "forgot", Toast.LENGTH_SHORT).show();
    }

    public void signUp(Context context){
        Toast.makeText(context, "sign up", Toast.LENGTH_SHORT).show();
    }

    public void facebookLogin(Context context){
        Toast.makeText(context, "facebook login", Toast.LENGTH_SHORT).show();
    }

    public void skypeLogin(Context context){
        Toast.makeText(context, "skype login", Toast.LENGTH_SHORT).show();
    }
}
