package com.example.titshop.ui.register;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.titshop.R;
import com.example.titshop.api.RetrofitClient;
import com.example.titshop.api.ShoppeService;
import com.example.titshop.base.BaseActivity;
import com.example.titshop.databinding.ActivityRegisterBinding;
import com.example.titshop.ui.login.LoginActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends BaseActivity<ActivityRegisterBinding,RegisterViewModel> {
    @Override
    public Class<RegisterViewModel> getViewmodel() {
        return RegisterViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_register;
    }

    @Override
    public void setBindingViewmodel() {
             binding.setViewmodel(viewmodel);
             event();
    }

    private void event() {
        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterAccount();
            }
        });
        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void RegisterAccount(){
        String username = binding.edtUsername.getText().toString();
        String sdt = binding.edtPhone.getText().toString();
        String mk = binding.edtPass.getText().toString();
        String dc = binding.edtAddress.getText().toString();
        if(username.equals("")  || sdt.equals("") || mk.equals("") || dc.equals("")){
            Toast.makeText(RegisterActivity.this, "Không được bỏ trống!", Toast.LENGTH_SHORT).show();
        }else{
            ShoppeService shoppeService = RetrofitClient.getInstance(RegisterActivity.this).create(ShoppeService.class);
            Call<String> call = shoppeService.Register(username,sdt,mk,"https://cdn.shopify.com/s/files/1/0267/2630/1768/products/design-your-own-sd-chibianime-characters-online-digital-drawing-class-digital-drawing-yuno-251928_800x.jpg?v=1591253641",dc);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if(response.body().equalsIgnoreCase("succes")){
                        Toast.makeText(RegisterActivity.this, "Đăng kí thành công !", Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(RegisterActivity.this, "Số điện thoại đã dc sử dụng rùi  !", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Toast.makeText(RegisterActivity.this, "Call api fail due to  " + t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
    }
}
