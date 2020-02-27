package com.example.titshop.fragment.detailproduct;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;

import com.example.titshop.R;
import com.example.titshop.adapter.detailPageAdapter;
import com.example.titshop.base.BaseFragment;
import com.example.titshop.callback.ActionbarListener;
import com.example.titshop.databinding.FragDetailproductBinding;
import com.example.titshop.fragment.inforproduct.InforProductFragment;
import com.example.titshop.fragment.profile.ProfileFragment;
import com.example.titshop.fragment.review.ReviewFragment;
import com.example.titshop.fragment.shipping.ShippingFragment;
import com.example.titshop.model.Product;

public class DetailFragment extends BaseFragment<FragDetailproductBinding,DetailProductViewModel> {
    ActionbarListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (ActionbarListener) context;
    }

    @Override
    public Class<DetailProductViewModel> getViewmodel() {
        return DetailProductViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.frag_detailproduct;
    }

    @Override
    public void setBindingViewmodel() {
        binding.setViewmodel(viewmodel);
    }

    private void setupViewPagerandTab() {
        detailPageAdapter adapter = new detailPageAdapter(getChildFragmentManager());
        adapter.addFragment(new InforProductFragment(),"Detail");
        adapter.addFragment(new ReviewFragment(),"Reviews");
        binding.viewPager.setAdapter(adapter);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
        Log.d("sonxxx","settup");
        // hi
    }

    @Override
    public void ViewCreated() {
        setupViewPagerandTab();
        viewmodel.getProduct().observe(this, new Observer<Product>() {
            @Override
            public void onChanged(Product product) {
                binding.setProduct(product);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        listener.onResumFragment(this);
    }
}
