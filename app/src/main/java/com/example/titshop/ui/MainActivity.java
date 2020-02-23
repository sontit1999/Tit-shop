package com.example.titshop.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.titshop.R;
import com.example.titshop.base.BaseActivity;
import com.example.titshop.databinding.ActivityMainBinding;
import com.example.titshop.ui.login.LoginActivity;
import com.example.titshop.ui.register.RegisterActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Override
    public Class<MainViewModel> getViewmodel() {
        return MainViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void setBindingViewmodel() {
        binding.setViewmodel(viewmodel);
        event();
    }

    private void event() {
        binding.llLoginEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
        binding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });
    }
}
