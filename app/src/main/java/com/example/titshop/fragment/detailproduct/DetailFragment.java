package com.example.titshop.fragment.detailproduct;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.bumptech.glide.Glide;
import com.example.titshop.R;
import com.example.titshop.adapter.detailPageAdapter;
import com.example.titshop.base.BaseFragment;
import com.example.titshop.callback.ActionbarListener;
import com.example.titshop.databinding.FragDetailproductBinding;
import com.example.titshop.fragment.inforproduct.InforProductFragment;
import com.example.titshop.fragment.profile.ProfileFragment;
import com.example.titshop.fragment.review.ReviewFragment;
import com.example.titshop.fragment.shipping.ShippingFragment;
import com.example.titshop.model.CartItem;
import com.example.titshop.model.CommentResponse;
import com.example.titshop.model.Product;
import com.example.titshop.roomdb.AppDatabase;
import com.example.titshop.roomdb.CartDAO;
import com.example.titshop.roomdb.ProductLike;
import com.example.titshop.roomdb.ProductView;
import com.example.titshop.ultis.Constant;

import java.util.ArrayList;
import java.util.List;

public class DetailFragment extends BaseFragment<FragDetailproductBinding,DetailProductViewModel> {
    ActionbarListener listener;
    Product product = null;
    CartDAO cartDAO = null;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (ActionbarListener) context;
    }

    @Override
    public Class<DetailProductViewModel> getViewmodel() {
        return DetailProductViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.frag_detailproduct;
    }

    @Override
    public void setBindingViewmodel() {
        binding.setViewmodel(viewmodel);
        Bundle bundle = getArguments();
        initRoomDatabase();
        if(bundle!=null){
            product = (Product) bundle.getSerializable("product");
        }
    }



    @Override
    public void ViewCreated() {
        // add to view product
        ProductView productView = new ProductView(product.getId(),product.getName(),product.getMota(),product.getGia(),product.getLinkanh(),product.getNumberbuy(),product.getIdtype());
        Constant.getDatabase().getProductViewDao().insert(productView);
        setUpreCyclerviewComment();
        // gán data lên view
        binDATA();
        event();

        viewmodel.getArrComment(getContext(),Integer.parseInt(product.getId())).observe(this, new Observer<List<CommentResponse>>() {
            @Override
            public void onChanged(List<CommentResponse> commentResponses) {
                viewmodel.commentAdapter.setList((ArrayList<CommentResponse>) commentResponses);
            }
        });
    }
    private void setUpreCyclerviewComment() {
        binding.rvComment.setAdapter(viewmodel.commentAdapter);
        binding.rvComment.setHasFixedSize(true);
        binding.rvComment.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false));
    }

    private void binDATA() {
        if(product!=null){
            Glide.with(getContext()).load(product.getLinkanh()).into(binding.ivProduct);
            binding.tvNameProduct.setText(product.getName());
            binding.tvDesciption.setText(product.getMota());
            binding.tvNumberBuy.setText("Đã bán " + product.getNumberbuy() );
            binding.tvPriceProduct.setText(product.getGia() + "vnđ");
        }
    }
    private void initRoomDatabase() {
        Constant.initDatabase(getContext());
        cartDAO = Constant.getDatabase().getCartDao();
    }
    private void event() {
        binding.ivLikeProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductLike productLike = new ProductLike(product.getId(),product.getName(),product.getMota(),product.getGia(),product.getLinkanh(),product.getNumberbuy(),product.getIdtype());
                Constant.getDatabase().getProductLikeDao().insert(productLike);
                Toast.makeText(getActivity(), "Đã thêm vào sp ưa thích !", Toast.LENGTH_SHORT).show();
            }
        });
        binding.btnAddtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartItem  cartItem = new CartItem("1",product.getId(),product.getName(),product.getMota(),product.getGia(),product.getLinkanh(),product.getNumberbuy(),product.getIdtype());
                     cartDAO.insert(cartItem);
                Toast.makeText(getActivity(), "Đã thêm vào giỏ hàng!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onResume() {
        super.onResume();
        listener.onResumFragment(this);
    }
}
