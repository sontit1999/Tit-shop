package com.example.titshop.fragment.product;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.titshop.R;
import com.example.titshop.adapter.ProductAdapter;
import com.example.titshop.base.BaseFragment;
import com.example.titshop.databinding.FragProductBinding;
import com.example.titshop.model.SubProduct;

import java.util.ArrayList;

public class ProductFragment extends BaseFragment<FragProductBinding, ProductFragViewModel> {
    private ProductAdapter adapter;

    @Override
    public Class<ProductFragViewModel> getViewmodel() {
        return ProductFragViewModel.class;
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
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
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
            }
        });

    }
}
