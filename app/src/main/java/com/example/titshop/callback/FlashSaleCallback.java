package com.example.titshop.callback;

import com.example.titshop.base.CBAdapter;
import com.example.titshop.model.Product;

public interface FlashSaleCallback extends CBAdapter {
    void onCLickProduct(Product product);
}
