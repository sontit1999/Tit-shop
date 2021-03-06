package com.example.titshop.adapter;

import androidx.databinding.library.baseAdapters.BR;

import com.example.titshop.R;
import com.example.titshop.base.BaseAdapter;
import com.example.titshop.base.CBAdapter;
import com.example.titshop.callback.FlashSaleCallback;
import com.example.titshop.databinding.ItemProductBinding;
import com.example.titshop.model.Product;


public class ProductAdapter extends BaseAdapter<Product, ItemProductBinding> {
   FlashSaleCallback callback;

    public void setCallback(FlashSaleCallback callback) {
        this.callback = callback;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_product;
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
