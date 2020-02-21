package com.example.titshop.adapter;

import com.example.titshop.BR;
import com.example.titshop.R;
import com.example.titshop.base.BaseAdapter;
import com.example.titshop.base.CBAdapter;
import com.example.titshop.databinding.ItemWishlistBinding;
import com.example.titshop.model.Product;

public class WishlistAdapter extends BaseAdapter<Product, ItemWishlistBinding> {
    @Override
    public int getLayoutId() {
        return R.layout.item_wishlist;
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
