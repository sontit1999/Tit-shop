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
import com.example.titshop.callback.ProductViewCallback;
import com.example.titshop.callback.WishlishCallback;
import com.example.titshop.databinding.FragWishlistBinding;
import com.example.titshop.model.Product;
import com.example.titshop.roomdb.ProductLike;
import com.example.titshop.roomdb.ProductView;
import com.example.titshop.ultis.Constant;

import java.util.ArrayList;
import java.util.Collections;

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
       // get type frag
        Bundle bundle = getArguments();
        if(bundle!=null){
            type = bundle.getString("type", Constant.typeLike);
        }
    }

    private void bindTitle() {
       switch (type){
           case Constant.typeBought:
               listener.onBoughtFragment();
               break;
           case Constant.typeView:
               listener.onViewFragment();
               binding.rvWishlist.setAdapter(viewmodel.viewedProductAdapter);
               ArrayList<ProductView> arr = (ArrayList) Constant.getDatabase().getProductViewDao().getAllProduct();
               Collections.reverse(arr);
               viewmodel.viewedProductAdapter.setList(arr);
               viewmodel.viewedProductAdapter.setCallback(new ProductViewCallback() {
                   @Override
                   public void onClickItem(ProductView productView) {
                       Product product = new Product(productView.getId(),productView.getName(),productView.getMota(),productView.getGia(),productView.getLinkanh(),productView.getNumberbuy(),productView.getIdtype());
                       Bundle bundle = new Bundle();
                       bundle.putSerializable("product", product);
                       getControler().navigate(R.id.action_wishLishFragment_to_DetailFragment,bundle);
                   }
               });
               break;
           case Constant.typeLike:
               listener.onLikeFragment();
               binding.rvWishlist.setAdapter(viewmodel.wishlistAdapter);
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

    }

    @Override
    public void ViewCreated() {
          initRecyclerview();
          bindTitle();
          viewmodel.getArrWishlish().observe(this, new Observer<ArrayList<ProductLike>>() {
              @Override
              public void onChanged(ArrayList<ProductLike> productLikes) {
                  Collections.reverse(productLikes);
                  viewmodel.wishlistAdapter.setList(productLikes);
                  viewmodel.wishlistAdapter.setCallback(new WishlishCallback() {
                      @Override
                      public void onItemClick(View view, ProductLike productLike) {
                          Product product = new Product(productLike.getId(),productLike.getName(),productLike.getMota(),productLike.getGia(),productLike.getLinkanh(),productLike.getNumberbuy(),productLike.getIdtype());
                          Bundle bundle = new Bundle();
                          bundle.putSerializable("product", product);
                          getControler().navigate(R.id.action_wishLishFragment_to_DetailFragment,bundle);
                      }

                      @Override
                      public void onRemove(View view, ProductLike productLike) {
                            int index = viewmodel.wishlistAdapter.getList().indexOf(productLike);
                            viewmodel.wishlistAdapter.removeItem(index);

                            Constant.getDatabase().getProductLikeDao().delete(productLike);
                      }
                  });
              }
          });

    }


}
