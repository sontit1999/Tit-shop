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
    private String urlAdvertise1 = "https://previews.123rf.com/images/luckyraccoon/luckyraccoon1801/luckyraccoon180100015/92938409-beautiful-woman-with-shopping-bags-looking-at-her-phone-while-going-out-on-a-shopping-spree-.jpg";

    public String getUrlAdvertise1() {
        return urlAdvertise1;
    }

    public String getUrlUrlAdvertise2() {
        return urlUrlAdvertise2;
    }

    private String urlUrlAdvertise2 = "https://previews.123rf.com/images/ammentorp/ammentorp1710/ammentorp171000656/88933120-outdoor-shot-of-beautiful-woman-with-many-shopping-bags-asian-female-model-walking-on-the-city-stree.jpg";

    public MutableLiveData<ArrayList<Product>> getArrProductsearch() {
        return arrProductsearch;
    }

    private MutableLiveData<ArrayList<Product>> arrProductsearch = new MutableLiveData<>();
    public void setListSearch(ArrayList<Product> arr){
        arrProductsearch.postValue(arr);
    }

}
