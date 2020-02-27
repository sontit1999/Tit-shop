package com.example.titshop.adapter;

import com.example.titshop.BR;
import com.example.titshop.R;
import com.example.titshop.base.BaseAdapter;
import com.example.titshop.base.CBAdapter;
import com.example.titshop.callback.ProductCallback;
import com.example.titshop.databinding.ItemProductBinding;
import com.example.titshop.model.SubProduct;

public class ProductAdapter extends BaseAdapter<SubProduct, ItemProductBinding> {
    ProductCallback callback;
    @Override
    public int getLayoutId() {
        return R.layout.item_product;
    }

    @Override
    public int getIdVariable() {
        return BR.subproduct;
    }

    @Override
    public int getIdVariableOnclick() {
        return BR.callback;
    }

    @Override
    public CBAdapter getOnclick() {
        return callback;
    }

    public void setCallback(ProductCallback callback) {
        this.callback = callback;
    }
}
