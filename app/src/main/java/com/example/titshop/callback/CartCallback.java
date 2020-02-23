package com.example.titshop.callback;

import com.example.titshop.base.CBAdapter;
import com.example.titshop.model.Product;

public interface CartCallback extends CBAdapter {
    void ontang(Product product);
    void ongiam(Product product);
    void onProductClick(Product product);
}
