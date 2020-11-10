package com.example.titshop.fragment.wishlist;

import androidx.lifecycle.MutableLiveData;

import com.example.titshop.adapter.SearchAdapter;
import com.example.titshop.adapter.ViewedProductAdapter;
import com.example.titshop.adapter.WishlistAdapter;
import com.example.titshop.base.BaseViewmodel;
import com.example.titshop.model.Product;
import com.example.titshop.roomdb.ProductLike;
import com.example.titshop.ultis.Constant;

import java.util.ArrayList;

public class WishListViewModel extends BaseViewmodel {
    WishlistAdapter wishlistAdapter = new WishlistAdapter();
    ViewedProductAdapter viewedProductAdapter = new ViewedProductAdapter();
    private MutableLiveData<ArrayList<ProductLike>> arrProductwishlist = new MutableLiveData<>();
    public MutableLiveData<ArrayList<ProductLike>> getArrWishlish(){
        ArrayList<ProductLike> arr = (ArrayList<ProductLike>) Constant.getDatabase().getProductLikeDao().getAllCart();
        arrProductwishlist.postValue(arr);
        return arrProductwishlist;
    }
}
