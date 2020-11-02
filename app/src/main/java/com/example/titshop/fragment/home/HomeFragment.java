package com.example.titshop.fragment.home;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.titshop.R;
import com.example.titshop.adapter.SliderAdapterExample;
import com.example.titshop.base.BaseFragment;
import com.example.titshop.callback.ActionbarListener;
import com.example.titshop.callback.CagetoryCallback;
import com.example.titshop.callback.FlashSaleCallback;
import com.example.titshop.databinding.FragHomeBinding;
import com.example.titshop.fragment.Fragment;
import com.example.titshop.fragment.product.ProductFragment;
import com.example.titshop.fragment.shipping.ShippingFragment;
import com.example.titshop.model.Cagetory;
import com.example.titshop.model.Product;
import com.example.titshop.model.SliderItem;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeFragment extends BaseFragment<FragHomeBinding,HomeFragViewModel> {
    ActionbarListener listener;
    SliderAdapterExample adapter ;
    @Override
    public Class<HomeFragViewModel> getViewmodel() {
        return HomeFragViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.frag_home;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (ActionbarListener) context;
    }

    @Override
    public void setBindingViewmodel() {
        binding.setViewmodel(viewmodel);
        initSilde();
        initRecyclerview();

    }

    private void event() {
        binding.tvShowAllToptrend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cagetory cagetory = new Cagetory("999","Top Trend","xx","xx");
                Bundle bundle = new Bundle();
                bundle.putSerializable("type", cagetory);
                getControler().navigate(R.id.action_homeFragment_to_productFragment,bundle);
            }
        });
        binding.tvShowAllFlashSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cagetory cagetory = new Cagetory("888","Flash sale","xx","xx");
                Bundle bundle = new Bundle();
                bundle.putSerializable("type", cagetory);
                getControler().navigate(R.id.action_homeFragment_to_productFragment,bundle);
            }
        });
    }

    private void initRecyclerview() {
          // init recyclerview flash sale
         RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
         binding.rvCollection.setHasFixedSize(true);
         binding.rvCollection.setLayoutManager(layoutManager);
         binding.rvCollection.setAdapter(viewmodel.flashSaleAdapter);

         // init recyclerview toptrend
        binding.rvToptrend.setAdapter(viewmodel.productAdapter);
        binding.rvToptrend.setHasFixedSize(true);
        binding.rvToptrend.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));

        // init rv cagetory
        binding.rvCagetory.setAdapter(viewmodel.cagetoryAdapter);
        binding.rvCagetory.setHasFixedSize(true);
        binding.rvCagetory.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.HORIZONTAL, false));
    }

    private void initSilde() {
        adapter = new SliderAdapterExample(getContext());
        binding.imageSlider.setSliderAdapter(adapter);
        binding.imageSlider.setIndicatorAnimation(IndicatorAnimations.WORM); // hiệu ứng incadiotor
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION); // hiệu ứng chuyển cảnh
        binding.imageSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        binding.imageSlider.setIndicatorSelectedColor(Color.WHITE);
        binding.imageSlider.setIndicatorUnselectedColor(Color.GRAY);
        binding.imageSlider.setScrollTimeInSec(3);
        binding.imageSlider.setAutoCycle(true);
        binding.imageSlider.startAutoCycle();
    }

    @Override
    public void ViewCreated() {
        viewmodel.getArrItem().observe(this, new Observer<List<SliderItem>>() {
            @Override
            public void onChanged(List<SliderItem> sliderItems) {
                adapter.renewItems(sliderItems);
            }
        });
        viewmodel.getArrFlashSale(getContext()).observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                viewmodel.flashSaleAdapter.setList((ArrayList<Product>) products);
                viewmodel.flashSaleAdapter.setCallback(new FlashSaleCallback() {
                    @Override
                    public void onCLickProduct(Product product) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("product", product);
                        getControler().navigate(R.id.action_navigationShop_to_DetailFragment,bundle);
                    }
                });
            }
        });
        viewmodel.getArrCagetory(getContext()).observe(this, new Observer<List<Cagetory>>() {
            @Override
            public void onChanged(List<Cagetory> cagetories) {
                viewmodel.cagetoryAdapter.setList((ArrayList<Cagetory>) cagetories);
                viewmodel.cagetoryAdapter.setCallback(new CagetoryCallback() {
                    @Override
                    public void onCagetoryCLick(Cagetory cagetory) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("type", cagetory);
                        getControler().navigate(R.id.action_homeFragment_to_productFragment,bundle);
                    }
                });
            }
        });
        viewmodel.getArrRecomendProduct(getContext()).observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                viewmodel.productAdapter.setList((ArrayList<Product>) products);
                viewmodel.productAdapter.setCallback(new FlashSaleCallback() {
                    @Override
                    public void onCLickProduct(Product product) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("product", product);
                        getControler().navigate(R.id.action_navigationShop_to_DetailFragment,bundle);
                    }
                });
            }
        });
        event();
    }

    @Override
    public void onResume() {
        super.onResume();
        listener.onResumFragment(this);
    }
}
