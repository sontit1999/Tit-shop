package com.example.titshop.ui.login;

import android.view.View;
import android.widget.Toast;

import com.example.titshop.R;
import com.example.titshop.base.BaseActivity;
import com.example.titshop.databinding.ActivityLoginBinding;

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
                Toast.makeText(LoginActivity.this, "Login success", Toast.LENGTH_SHORT).show();
            }
        });

        binding.txtForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Chuyển đến màn hình quên mật khẩu", Toast.LENGTH_SHORT).show();
            }
        });

        binding.txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Chuyển đến màn hình đăng kí tài khoản", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
