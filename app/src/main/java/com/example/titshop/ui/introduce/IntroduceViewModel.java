package com.example.titshop.ui.introduce;

import androidx.lifecycle.MutableLiveData;

import com.example.titshop.adapter.IntroduceAdapter;
import com.example.titshop.base.BaseViewmodel;
import com.example.titshop.model.Introduce;

import java.util.ArrayList;

public class IntroduceViewModel extends BaseViewmodel {
    IntroduceAdapter adapter = new IntroduceAdapter();
    private MutableLiveData<ArrayList<Introduce>> arrIntroduce = new MutableLiveData<>();
    public MutableLiveData<ArrayList<Introduce>> getIntroduce(){
        ArrayList<Introduce> arr = new ArrayList<>();
        arr.add(new Introduce("https://i.pinimg.com/564x/90/a6/ec/90a6ec6530cf2a3a64135ad4f571c8ad.jpg"));
        arr.add(new Introduce("https://i.pinimg.com/564x/71/92/db/7192db6c0beae97843f30d74e19f3d59.jpg"));
        arr.add(new Introduce("https://i.pinimg.com/564x/c4/4a/7e/c44a7edf6fc62f2e8947dbf5da7dde9c.jpg"));
        arr.add(new Introduce("https://i.pinimg.com/564x/0c/82/c7/0c82c726ccea6767347dde9baa8a9ec3.jpg"));
        arrIntroduce.postValue(arr);
        return arrIntroduce;
    }
}
