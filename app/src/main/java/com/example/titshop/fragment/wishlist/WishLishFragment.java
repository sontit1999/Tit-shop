package com.example.titshop.fragment.wishlist;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.titshop.R;
import com.example.titshop.base.BaseFragment;
import com.example.titshop.callback.ActionbarListener;
import com.example.titshop.databinding.FragWishlistBinding;
import com.example.titshop.model.Product;

import java.util.ArrayList;

public class WishLishFragment extends BaseFragment<FragWishlistBinding, WishListViewModel> {
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
              public void onChanged(ArrayList<Product> products) {
                  viewmodel.wishlistAdapter.setList(products);
              }
          });
    }

    @Override
    public void onResume() {
        super.onResume();
        listener.onResumFragment(this);
    }
}
