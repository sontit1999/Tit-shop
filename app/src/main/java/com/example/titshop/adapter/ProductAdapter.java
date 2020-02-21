package com.example.titshop.adapter;

import com.example.titshop.BR;
import com.example.titshop.R;
import com.example.titshop.base.BaseAdapter;
import com.example.titshop.base.CBAdapter;
import com.example.titshop.databinding.ItemProductBinding;
import com.example.titshop.model.SubProduct;

public class ProductAdapter extends BaseAdapter<SubProduct, ItemProductBinding> {
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
        return 0;
    }

    @Override
    public CBAdapter getOnclick() {
        return null;
    }

}
