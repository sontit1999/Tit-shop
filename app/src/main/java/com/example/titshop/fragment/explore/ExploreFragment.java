package com.example.titshop.fragment.explore;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.titshop.R;
import com.example.titshop.base.BaseFragment;
import com.example.titshop.callback.ActionbarListener;
import com.example.titshop.databinding.FragExploreBinding;
import com.example.titshop.model.Product;

import java.util.ArrayList;
import java.util.Collections;

public class ExploreFragment extends BaseFragment<FragExploreBinding,ExploreViewModel> {
    ActionbarListener listener;
    @Override
    public Class<ExploreViewModel> getViewmodel() {
        return ExploreViewModel.class;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (ActionbarListener) context;
    }

    @Override
    public int getLayoutID() {
        return R.layout.frag_explore;
    }

    @Override
    public void setBindingViewmodel() {
        binding.setViewmodel(viewmodel);
        initRecyclerview();
        event();
    }

    private void initRecyclerview() {
        // init recyclerview toptrend
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        binding.rvSearch.setHasFixedSize(true);
        binding.rvSearch.setLayoutManager(manager);
        binding.rvSearch.setAdapter(viewmodel.searchAdapter);
    }

    private void event() {
        binding.edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                  hiddenornot();
            }
        });
    }

    private void searchProduct(String keyword) {
        ArrayList<Product> arr = new ArrayList<>();
        arr.add(new Product(" Korean Style Women","https://my-test-11.slatic.net/p/7/kobwa-korean-style-women-fashion-casual-pu-leather-ladies-handbag-shoulder-bucket-tote-bag-brown-8138-099175611-084e0414bbec596b0199d890d826bd3b-.jpg_600x600q80.jpg","$69","x","dress","99",4.5f));
        arr.add(new Product("Bat sloweet wolan","https://ae01.alicdn.com/kf/HTB1DP_RXWSs3KVjSZPiq6AsiVXa5/2020-Plus-Size-Bat-Sleeved-Woolen-Coat-Scarf-Collar-Jackets-Women-Winter-Fashion-Outerwear-Thicker-Loose.jpg","$24.47","x","dress","132",4.5f));
        arr.add(new Product("T-shrit ladies","https://i.pinimg.com/736x/fc/07/d4/fc07d472f7a97762b5e2374446a8543f.jpg","$24.89","x","x","23",4.5f));
        arr.add(new Product("Big Deal Kevin","https://ae01.alicdn.com/kf/HTB1MftjbdzvK1RkSnfoq6zMwVXan/KENVY-Brand-Fashion-Women-s-High-end-Luxury-Winter-Contrast-Color-Jacquard-Knitted-Cotton-Casual-Sweater.jpg","$11.89","x","x","23",4.5f));
        arr.add(new Product("Girl sweammer","https://d2nikgq6rubtj8.cloudfront.net/web/2019/Sept/04/nav/womens-nav.jpg","$12.94","x","x","56",4.5f));
        arr.add(new Product("Sustainable Women's Fashion xxxxxxxxxxxxxxxxxxxxxx","https://ae01.alicdn.com/kf/HTB1YYlaPpXXXXX.XXXXq6xXFXXXx/Wanita-Piyama-Sutra-Celana-Pendek-Tombol-Lengan-Pendek-Kemeja-Dan-Pendek-Set-2016-Musim-Panas-Wanita.jpg","$99","x","x","96",4.5f));
        Collections.shuffle(arr);
        viewmodel.setListSearch(arr);
    }

    private void hiddenornot() {
        if(binding.edtSearch.getText().toString().trim().equals("")){
            binding.llDesignWomen.setVisibility(View.VISIBLE);
            viewmodel.setListSearch(new ArrayList<Product>());
        }else{
            binding.llDesignWomen.setVisibility(View.INVISIBLE);
            searchProduct(binding.edtSearch.getText().toString().trim());
        }

    }

    @Override
    public void ViewCreated() {
            viewmodel.getArrToptrend().observe(this, new Observer<ArrayList<Product>>() {
                @Override
                public void onChanged(ArrayList<Product> products) {
                    viewmodel.searchAdapter.setList(products);
                }
            });
    }

    @Override
    public void onResume() {
        super.onResume();
        listener.onResumFragment(this);
    }
}
