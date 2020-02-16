package com.example.titshop.ui;

import android.view.View;
import android.widget.Toast;

import com.example.titshop.R;
import com.example.titshop.base.BaseActivity;
import com.example.titshop.databinding.ActivityMainBinding;

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
        binding.llLoginFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               viewmodel.LoginWithFb(MainActivity.this);
            }
        });
        binding.llLoginEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewmodel.LoginWithEmail(MainActivity.this);
            }
        });
    }
}
