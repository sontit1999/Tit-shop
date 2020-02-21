package com.example.titshop.adapter;

import com.example.titshop.BR;
import com.example.titshop.R;
import com.example.titshop.base.BaseAdapter;
import com.example.titshop.base.CBAdapter;
import com.example.titshop.databinding.ItemDesignCollectionBinding;
import com.example.titshop.model.Product;

public class CollectionAdapter extends BaseAdapter<Product, ItemDesignCollectionBinding> {
    @Override
    public int getLayoutId() {
        return R.layout.item_design_collection;
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
