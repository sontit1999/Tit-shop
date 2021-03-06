package com.example.titshop.adapter;

import com.example.titshop.BR;
import com.example.titshop.R;
import com.example.titshop.base.BaseAdapter;
import com.example.titshop.base.CBAdapter;
import com.example.titshop.callback.WishlishCallback;
import com.example.titshop.databinding.ItemWishlistBinding;
import com.example.titshop.model.Product;
import com.example.titshop.roomdb.ProductLike;

public class WishlistAdapter extends BaseAdapter<ProductLike, ItemWishlistBinding> {
    WishlishCallback callback;
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
        return BR.callback;
    }

    @Override
    public CBAdapter getOnclick() {
        return callback;
    }

    public void setCallback(WishlishCallback callback) {
        this.callback = callback;
    }
}
