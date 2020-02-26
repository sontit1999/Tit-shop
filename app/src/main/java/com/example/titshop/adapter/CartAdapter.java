package com.example.titshop.adapter;

import com.example.titshop.BR;
import com.example.titshop.R;
import com.example.titshop.base.BaseAdapter;
import com.example.titshop.base.CBAdapter;
import com.example.titshop.callback.CartCallback;
import com.example.titshop.databinding.ItemCartBinding;
import com.example.titshop.model.CartItem;
import com.example.titshop.model.Product;

public class CartAdapter extends BaseAdapter<CartItem, ItemCartBinding> {
    CartCallback callback;
    @Override
    public int getLayoutId() {
        return R.layout.item_cart;
    }

    @Override
    public int getIdVariable() {
        return BR.carditem;
    }

    @Override
    public int getIdVariableOnclick() {
        return BR.callback;
    }

    @Override
    public CBAdapter getOnclick() {
        return callback;
    }

    public void setCallback(CartCallback callback) {
        this.callback = callback;
    }
    public String getTotal(){
        float total = 0;
        for(CartItem i : datalist){
            total += i.pay();
        }
        return "$" + total ;
    }
}
