package com.example.titshop.fragment.explore;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.titshop.R;
import com.example.titshop.api.RetrofitClient;
import com.example.titshop.api.ShoppeService;
import com.example.titshop.base.BaseFragment;
import com.example.titshop.callback.ActionbarListener;
import com.example.titshop.callback.FlashSaleCallback;
import com.example.titshop.databinding.FragExploreBinding;
import com.example.titshop.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExploreFragment extends BaseFragment<FragExploreBinding,ExploreViewModel> {
    ActionbarListener listener;
    List<Product> arrAllProduct;
    @Override
    public Class<ExploreViewModel> getViewmodel() {
        return ExploreViewModel.class;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (ActionbarListener) context;
    }

    @Override
    public int getLayoutID() {
        return R.layout.frag_explore;
    }

    @Override
    public void setBindingViewmodel() {
        binding.setViewmodel(viewmodel);
        initRecyclerview();
        event();
    }

    private void initRecyclerview() {
        // init recyclerview toptrend
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        binding.rvSearch.setHasFixedSize(true);
        binding.rvSearch.setLayoutManager(manager);
        binding.rvSearch.setAdapter(viewmodel.searchAdapter);
    }

    private void event() {
        binding.edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                 SearchIng(editable.toString());
            }
        });
    }

    private void SearchIng(String keyword) {
        keyword = keyword.toLowerCase();
        List<Product> arrSeach = new ArrayList<>();
        for (Product i: arrAllProduct) {
            if(i.getName().toLowerCase().contains(keyword)){
                arrSeach.add(i);
            }

        }
        viewmodel.setListSearch((ArrayList<Product>) arrSeach);
    }


    @Override
    public void ViewCreated() {
        ShoppeService shoppeService = RetrofitClient.getInstance(getContext()).create(ShoppeService.class);
        Call<List<Product>> call = shoppeService.getAllProduct();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                arrAllProduct = response.body();
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });

        viewmodel.getArrProductsearch().observe(this, new Observer<ArrayList<Product>>() {
            @Override
            public void onChanged(ArrayList<Product> products) {
                if(products.size()>0){
                    binding.llDesignWomen.setVisibility(View.GONE);

                }
                viewmodel.searchAdapter.setList(products);
                viewmodel.searchAdapter.setCallback(new FlashSaleCallback() {
                    @Override
                    public void onCLickProduct(Product product) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("product", product);
                        getControler().navigate(R.id.action_navigationExplore_to_DetailFragment,bundle);
                    }
                });
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        listener.onResumFragment(this);

    }

}
