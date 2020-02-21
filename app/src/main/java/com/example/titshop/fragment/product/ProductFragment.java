package com.example.titshop.fragment.product;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.titshop.R;
import com.example.titshop.adapter.ProductAdapter;
import com.example.titshop.base.BaseFragment;
import com.example.titshop.callback.ActionbarListener;
import com.example.titshop.databinding.FragProductBinding;
import com.example.titshop.model.SubProduct;

import java.util.ArrayList;

public class ProductFragment extends BaseFragment<FragProductBinding, ProductFragViewModel> {
    ActionbarListener listener;
    @Override
    public Class<ProductFragViewModel> getViewmodel() {
        return ProductFragViewModel.class;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (ActionbarListener) context;
    }

    @Override
    public int getLayoutID() {
        return R.layout.frag_product;
    }

    @Override
    public void setBindingViewmodel() {
        binding.setViewmodel(viewmodel);
        initRecyclerview();
    }

    private void initRecyclerview() {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        binding.rvProduct.setHasFixedSize(true);
        binding.rvProduct.setLayoutManager(layoutManager);
        binding.rvProduct.setAdapter(viewmodel.ProductAdapter);
    }

    @Override
    public void ViewCreated() {
        viewmodel.getArrSubProductCollection().observe(this, new Observer<ArrayList<SubProduct>>() {
            @Override
            public void onChanged(ArrayList<SubProduct> subProducts) {
                viewmodel.ProductAdapter.setList(subProducts);
                binding.tvNumberItem.setText(subProducts.size() + " items found");
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        listener.onResumFragment(this);
    }
}
