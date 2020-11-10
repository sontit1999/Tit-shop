package com.example.titshop.adapter;

import com.example.titshop.BR;
import com.example.titshop.R;
import com.example.titshop.base.BaseAdapter;
import com.example.titshop.base.CBAdapter;
import com.example.titshop.callback.ProductViewCallback;
import com.example.titshop.callback.WishlishCallback;
import com.example.titshop.databinding.ItemViewBinding;
import com.example.titshop.roomdb.ProductView;

public class ViewedProductAdapter extends BaseAdapter<ProductView, ItemViewBinding> {


    ProductViewCallback callback;

    public void setCallback(ProductViewCallback callback) {
        this.callback = callback;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_view;
    }

    @Override
    public int getIdVariable() {
        return BR.productview;
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
