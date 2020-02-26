package com.example.titshop.callback;

import com.example.titshop.base.CBAdapter;
import com.example.titshop.model.CartItem;
import com.example.titshop.model.Product;

public interface CartCallback extends CBAdapter {
    void ontang(CartItem cartItem);
    void ongiam(CartItem cartItem);
    void onProductClick(CartItem cartItem);
}
