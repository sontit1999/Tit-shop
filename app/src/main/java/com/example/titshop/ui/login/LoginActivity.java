package com.example.titshop.ui.login;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.titshop.R;
import com.example.titshop.base.BaseActivity;
import com.example.titshop.databinding.ActivityLoginBinding;
import com.example.titshop.ui.forgotpass.ForgotActivity;
import com.example.titshop.ui.home.HomeActivity;
import com.example.titshop.ui.register.RegisterActivity;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> {


    @Override
    public Class<LoginViewModel> getViewmodel() {
        return LoginViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    public void setBindingViewmodel() {
        binding.setLogin(viewmodel);
        event();
    }

    private void event() {
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        binding.txtForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ForgotActivity.class));
            }
        });
        binding.tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }
}
