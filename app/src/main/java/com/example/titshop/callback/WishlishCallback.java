package com.example.titshop.callback;

import android.view.View;

import com.example.titshop.base.CBAdapter;
import com.example.titshop.model.Product;
import com.example.titshop.roomdb.ProductLike;

public interface WishlishCallback extends CBAdapter {
    void onItemClick(View view, ProductLike productLike);
    void onRemove(View view, ProductLike productLike);
}
