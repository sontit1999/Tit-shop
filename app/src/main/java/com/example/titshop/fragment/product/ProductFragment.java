package com.example.titshop.fragment.product;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.lifecycle.Observer;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.titshop.R;
import com.example.titshop.adapter.ProductAdapter;
import com.example.titshop.api.RetrofitClient;
import com.example.titshop.api.ShoppeService;
import com.example.titshop.base.BaseFragment;
import com.example.titshop.callback.ActionbarListener;
import com.example.titshop.callback.FlashSaleCallback;
import com.example.titshop.callback.ProductCallback;
import com.example.titshop.databinding.FragProductBinding;
import com.example.titshop.fragment.home.HomeFragment;
import com.example.titshop.fragment.profile.ProfileFragment;
import com.example.titshop.model.Cagetory;
import com.example.titshop.model.Product;
import com.example.titshop.model.SubProduct;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductFragment extends BaseFragment<FragProductBinding, ProductFragViewModel> {
    ActionbarListener listener;
    Cagetory cagetory = null;
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
        Bundle bundle  = getArguments();
        if(bundle!=null){
            cagetory = (Cagetory) bundle.getSerializable("type");
        }
    }
    @Override
    public void ViewCreated() {
        // set title
        binding.tvTitle.setText(cagetory.getNametype());
        setUpPRoduct();
        event();
        viewmodel.getArrFlashSale(getContext(),cagetory).observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                binding.tvNumberItem.setText(products.size() + " items found ");
                viewmodel.productAdapter.setList((ArrayList<Product>) products);
                viewmodel.productAdapter.setCallback(new FlashSaleCallback() {
                    @Override
                    public void onCLickProduct(Product product) {

                        Bundle bundle = new Bundle();
                        bundle.putSerializable("product", product);
                        getControler().navigate(R.id.action_productFragment_to_DetailFragment,bundle);
                    }
                });
            }
        });

    }
    private void event() {

    }

    private void setUpPRoduct() {
        binding.rvProduct.setAdapter(viewmodel.productAdapter);
        binding.rvProduct.setHasFixedSize(true);
        binding.rvProduct.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
    }
    @Override
    public void onResume() {
        super.onResume();
        listener.onResumFragment(this);
    }
}
