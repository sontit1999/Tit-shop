package com.example.titshop.callback;

import android.view.View;

import com.example.titshop.base.CBAdapter;
import com.example.titshop.model.Product;
import com.example.titshop.model.SubProduct;

public interface ProductCallback extends CBAdapter {
    void onProductClick(SubProduct product);
    void onLikeClick(View view,SubProduct product);
}
