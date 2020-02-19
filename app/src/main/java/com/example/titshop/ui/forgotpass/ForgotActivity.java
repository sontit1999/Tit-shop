package com.example.titshop.ui.forgotpass;

import com.example.titshop.R;
import com.example.titshop.base.BaseActivity;
import com.example.titshop.databinding.ActivityForgotBinding;

public class ForgotActivity extends BaseActivity<ActivityForgotBinding,ForgotViewModel> {
    @Override
    public Class<ForgotViewModel> getViewmodel() {
        return ForgotViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_forgot;
    }

    @Override
    public void setBindingViewmodel() {
          binding.setViewmodel(viewmodel);
    }
}
