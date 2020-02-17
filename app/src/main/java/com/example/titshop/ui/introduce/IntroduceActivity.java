package com.example.titshop.ui.introduce;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import com.example.titshop.R;
import com.example.titshop.base.BaseActivity;
import com.example.titshop.databinding.ActivityIntroduceBinding;
import com.example.titshop.model.Introduce;
import com.example.titshop.ui.MainActivity;

import java.util.ArrayList;


public class IntroduceActivity extends BaseActivity<ActivityIntroduceBinding,IntroduceViewModel> {
    @Override
    public Class<IntroduceViewModel> getViewmodel() {
        return IntroduceViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_introduce;
    }

    @Override
    public void setBindingViewmodel() {
          binding.setViewmodel(viewmodel);
          initRecyclerview();
          viewmodel.getIntroduce().observe(this, new Observer<ArrayList<Introduce>>() {
              @Override
              public void onChanged(ArrayList<Introduce> introduces) {
                  viewmodel.adapter.setList(introduces);
              }
          });
          event();
    }

    private void event() {
        binding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(IntroduceActivity.this, "Chuyển đến màn login", Toast.LENGTH_SHORT).show();
            }
        });
        binding.btnShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroduceActivity.this, MainActivity.class));
            }
        });
    }

    private void initRecyclerview() {
        binding.rvIntroduce.setAdapter(viewmodel.adapter);
    }
}
