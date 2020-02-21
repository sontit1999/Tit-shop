package com.example.titshop.adapter;

import com.example.titshop.BR;
import com.example.titshop.R;
import com.example.titshop.base.BaseAdapter;
import com.example.titshop.base.CBAdapter;
import com.example.titshop.databinding.ItemToptrendBinding;
import com.example.titshop.model.Product;

public class TopTrendAdapter extends BaseAdapter<Product, ItemToptrendBinding> {
    @Override
    public int getLayoutId() {
        return R.layout.item_toptrend;
    }

    @Override
    public int getIdVariable() {
        return BR.product;
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
