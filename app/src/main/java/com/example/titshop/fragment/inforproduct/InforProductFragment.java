package com.example.titshop.fragment.inforproduct;

import android.util.Log;

import androidx.lifecycle.Observer;

import com.example.titshop.R;
import com.example.titshop.base.BaseFragment;
import com.example.titshop.databinding.FragInforproductBinding;
import com.example.titshop.model.Product;

public class InforProductFragment extends BaseFragment<FragInforproductBinding,InforProductViewModel> {
    @Override
    public Class<InforProductViewModel> getViewmodel() {
        return InforProductViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.frag_inforproduct;
    }

    @Override
    public void setBindingViewmodel() {
       binding.setViewmodel(viewmodel);
    }

    @Override
    public void ViewCreated() {
        viewmodel.getProduct().observe(this, new Observer<Product>() {
            @Override
            public void onChanged(Product product) {
                binding.setProduct(product);
            }
        });
    }
}
