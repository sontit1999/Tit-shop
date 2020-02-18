package com.example.titshop.ui.login;

import android.view.View;

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
                viewmodel.facebookLogin(LoginActivity.this);
            }
        });

        binding.txtForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewmodel.forgot(LoginActivity.this);
            }
        });

        binding.txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewmodel.signUp(LoginActivity.this);
            }
        });

        binding.layoutFacebookLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewmodel.facebookLogin(LoginActivity.this);
            }
        });

        binding.layoutSkypeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewmodel.skypeLogin(LoginActivity.this);
            }
        });
    }
}
