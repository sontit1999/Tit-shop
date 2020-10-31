package com.example.titshop.adapter;


import com.example.titshop.BR;
import com.example.titshop.R;
import com.example.titshop.base.BaseAdapter;
import com.example.titshop.base.CBAdapter;
import com.example.titshop.callback.FlashSaleCallback;
import com.example.titshop.databinding.ItemFlashsaleBinding;
import com.example.titshop.model.Product;

public class FlashSaleAdapter extends BaseAdapter<Product, ItemFlashsaleBinding> {

    FlashSaleCallback callback;
    public void setCallback(FlashSaleCallback callback) {
        this.callback = callback;
    }
    @Override
    public int getLayoutId() {
        return R.layout.item_flashsale;
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
