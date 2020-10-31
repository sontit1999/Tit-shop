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
import com.example.titshop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class DetailFragment extends BaseFragment<FragDetailproductBinding,DetailProductViewModel> {
    ActionbarListener listener;
    Product product = null;
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
        if(bundle!=null){
            product = (Product) bundle.getSerializable("product");
        }
    }



    @Override
    public void ViewCreated() {
        setUpreCyclerviewComment();
        // gán data lên view
        binDATA();
        event();

//        viewmodel.getArrComment(getContext(),Integer.parseInt(product.getId())).observe(this, new Observer<List<CommentResponse>>() {
//            @Override
//            public void onChanged(List<CommentResponse> commentResponses) {
//                viewmodel.commentAdapter.setList((ArrayList<CommentResponse>) commentResponses);
//            }
//        });
    }
    private void setUpreCyclerviewComment() {
      //  binding.rvComment.setAdapter(viewmodel.commentAdapter);
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

    private void event() {
        binding.ivLikeProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Clik likes", Toast.LENGTH_SHORT).show();
            }
        });
        binding.btnAddtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    @Override
    public void onResume() {
        super.onResume();
        listener.onResumFragment(this);
    }
}
