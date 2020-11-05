package com.example.titshop.adapter;

import com.example.titshop.BR;
import com.example.titshop.R;
import com.example.titshop.base.BaseAdapter;
import com.example.titshop.base.CBAdapter;
import com.example.titshop.callback.FlashSaleCallback;
import com.example.titshop.databinding.ItemSearchBinding;
import com.example.titshop.model.Product;

public class SearchAdapter extends BaseAdapter<Product, ItemSearchBinding> {


    FlashSaleCallback callback;
    public void setCallback(FlashSaleCallback callback) {
        this.callback = callback;
    }
    @Override
    public int getLayoutId() {
        return R.layout.item_search;
    }

    @Override
    public int getIdVariable() {
        return BR.product;
    }

    @Override
    public int getIdVariableOnclick() {
        return BR.callback;
    }

    @Override
    public CBAdapter getOnclick() {
        return callback;
    }
}
