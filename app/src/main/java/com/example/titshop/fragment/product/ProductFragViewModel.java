package com.example.titshop.fragment.product;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.titshop.R;
import com.example.titshop.adapter.ProductAdapter;
import com.example.titshop.api.RetrofitClient;
import com.example.titshop.api.ShoppeService;
import com.example.titshop.base.BaseViewmodel;
import com.example.titshop.callback.FlashSaleCallback;
import com.example.titshop.model.Cagetory;
import com.example.titshop.model.Product;
import com.example.titshop.model.SubProduct;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductFragViewModel extends BaseViewmodel {
    ProductAdapter productAdapter = new ProductAdapter();
    MutableLiveData<List<Product>> arrProduct = new MutableLiveData<>();
    public MutableLiveData<List<Product>> getArrFlashSale(Context context, Cagetory cagetory) {

        if(cagetory.getIdtype().equalsIgnoreCase("888")){
            ShoppeService shoppeService = RetrofitClient.getInstance(context).create(ShoppeService.class);
            Call<List<Product>> call = shoppeService.getAllSaleProduct();
            call.enqueue(new Callback<List<Product>>() {
                @Override
                public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                    arrProduct.postValue(response.body());
                }

                @Override
                public void onFailure(Call<List<Product>> call, Throwable t) {

                }
            });
        }else if(cagetory.getIdtype().equalsIgnoreCase("999")){
            ShoppeService shoppeService = RetrofitClient.getInstance(context).create(ShoppeService.class);
            Call<List<Product>> call = shoppeService.getAllRecomendProduct();
            call.enqueue(new Callback<List<Product>>() {
                @Override
                public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                    arrProduct.postValue(response.body());
                }

                @Override
                public void onFailure(Call<List<Product>> call, Throwable t) {

                }
            });
        }else{
            ShoppeService shoppeService = RetrofitClient.getInstance(context).create(ShoppeService.class);
            Call<List<Product>> call = shoppeService.getProductByType(Integer.parseInt(cagetory.getIdtype()));
            call.enqueue(new Callback<List<Product>>() {
                @Override
                public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                   arrProduct.postValue(response.body());
                }

                @Override
                public void onFailure(Call<List<Product>> call, Throwable t) {
                    Toast.makeText(context, "call api fail: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        return arrProduct;
    }
}
