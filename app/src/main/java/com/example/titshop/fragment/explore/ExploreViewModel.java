package com.example.titshop.fragment.explore;

import androidx.lifecycle.MutableLiveData;

import com.example.titshop.adapter.SearchAdapter;
import com.example.titshop.adapter.TopTrendAdapter;
import com.example.titshop.base.BaseViewmodel;
import com.example.titshop.model.Product;
import com.example.titshop.model.SliderItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExploreViewModel extends BaseViewmodel {
    SearchAdapter searchAdapter = new SearchAdapter();
    private MutableLiveData<ArrayList<Product>> arrProductsearch = new MutableLiveData<>();
    public MutableLiveData<ArrayList<Product>> getArrToptrend(){
        return arrProductsearch;
    }
    public void setListSearch(ArrayList<Product> arr){
        arrProductsearch.postValue(arr);
    }
}
