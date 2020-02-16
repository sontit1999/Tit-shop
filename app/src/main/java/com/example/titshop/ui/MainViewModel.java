package com.example.titshop.ui;


import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.example.titshop.base.BaseViewmodel;

public class MainViewModel extends BaseViewmodel {
     // viết các function logic xử lý và data lấy ở ở đây
    public void Login(View view){
        Toast.makeText(view.getContext(), "Chuyển đến màn hình login", Toast.LENGTH_SHORT).show();
    }
    public void LoginWithEmail(Context context){
        Toast.makeText(context, "Login Email", Toast.LENGTH_SHORT).show();
    }
    public void LoginWithFb(Context context){
        Toast.makeText(context, "Login facebook", Toast.LENGTH_SHORT).show();
    }
}
