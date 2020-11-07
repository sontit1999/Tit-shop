package com.example.titshop.fragment.wishlist;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.titshop.R;
import com.example.titshop.base.BaseFragment;
import com.example.titshop.callback.ActionbarListener;
import com.example.titshop.callback.WishlishCallback;
import com.example.titshop.databinding.FragWishlistBinding;
import com.example.titshop.model.Product;
import com.example.titshop.ultis.Constant;

import java.util.ArrayList;

public class WishLishFragment extends BaseFragment<FragWishlistBinding, WishListViewModel> {
    String type = "";
    ActionbarListener listener;
    @Override
    public Class<WishListViewModel> getViewmodel() {
        return WishListViewModel.class;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (ActionbarListener) context;
    }

    @Override
    public int getLayoutID() {
        return R.layout.frag_wishlist;
    }

    @Override
    public void setBindingViewmodel() {
       binding.setViewmodel(viewmodel);
       initRecyclerview();
       // get type frag
        Bundle bundle = getArguments();
        if(bundle!=null){
            type = bundle.getString("type", Constant.typeLike);
        }
        bindTitle();
    }

    private void bindTitle() {
       switch (type){
           case Constant.typeBought:
               listener.onBoughtFragment();
               break;
           case Constant.typeView:
               listener.onViewFragment();
               break;
           case Constant.typeWait:
               listener.onWaitFragment();
               break;
       }
    }

    private void initRecyclerview() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        binding.rvWishlist.setHasFixedSize(true);
        binding.rvWishlist.setLayoutManager(manager);
        binding.rvWishlist.setAdapter(viewmodel.wishlistAdapter);
    }

    @Override
    public void ViewCreated() {
          viewmodel.getArrWishlish().observe(this, new Observer<ArrayList<Product>>() {
              @Override
              public void onChanged(final ArrayList<Product> products) {
                  viewmodel.wishlistAdapter.setList(products);
                  viewmodel.wishlistAdapter.setCallback(new WishlishCallback() {
                      @Override
                      public void onItemClick(View view, Product product) {

                      }

                      @Override
                      public void onRemove(View view, Product product) {
                          viewmodel.wishlistAdapter.removeItem(products.indexOf(product));
                      }
                  });
              }
          });

    }

    @Override
    public void onResume() {
        super.onResume();
       // listener.onResumFragment(this);
    }
}
