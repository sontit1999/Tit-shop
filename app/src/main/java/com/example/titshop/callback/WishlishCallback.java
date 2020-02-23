package com.example.titshop.callback;

import android.view.View;

import com.example.titshop.base.CBAdapter;
import com.example.titshop.model.Product;

public interface WishlishCallback extends CBAdapter {
    void onItemClick(View view,Product product);
    void onRemove(View view, Product product);
}
