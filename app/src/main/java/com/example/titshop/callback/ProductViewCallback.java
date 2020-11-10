package com.example.titshop.callback;

import com.example.titshop.base.CBAdapter;
import com.example.titshop.roomdb.ProductView;

public interface ProductViewCallback extends CBAdapter {
    void onClickItem(ProductView productView);
}
