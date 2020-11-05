package com.example.titshop.ui.login;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.titshop.R;
import com.example.titshop.api.RetrofitClient;
import com.example.titshop.api.ShoppeService;
import com.example.titshop.base.BaseActivity;
import com.example.titshop.databinding.ActivityLoginBinding;
import com.example.titshop.model.SingleTonUser;
import com.example.titshop.model.UserResponse;
import com.example.titshop.ui.forgotpass.ForgotActivity;
import com.example.titshop.ui.home.HomeActivity;
import com.example.titshop.ui.register.RegisterActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        binding.setViewmodel(viewmodel);
        event();
    }

    private void event() {
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sdt = binding.edtPhone.getText().toString();
                String pass = binding.edtPass.getText().toString();
                if(sdt.equals("") || pass.equals("")){
                    Toast.makeText(LoginActivity.this, "Phải nhập đủ thông tin để login!!", Toast.LENGTH_SHORT).show();
                }else{
                    if(sdt.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin")){
                       // getControler().navigate(R.id.action_LoginFragment_to_adminFragment);
                    }else{
                        ShoppeService shoppeService = RetrofitClient.getInstance(LoginActivity.this).create(ShoppeService.class);
                        Call<UserResponse> call = shoppeService.CheckLogin(sdt,pass);
                        call.enqueue(new Callback<UserResponse>() {
                            @Override
                            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                                if(response.body().getStatus().equals("success")){
                                    SingleTonUser.user = response.body();
                                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(LoginActivity.this, "Tài khoản hoặc mật khẩu không chính xác!!!", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<UserResponse> call, Throwable t) {
                                Toast.makeText(LoginActivity.this, "call api Fail due to " + t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }

            }
        });


        binding.tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }
}
