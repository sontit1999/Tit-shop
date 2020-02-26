package com.example.titshop.ui.home;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.titshop.R;
import com.example.titshop.adapter.CartAdapter;
import com.example.titshop.base.BaseActivity;
import com.example.titshop.base.BaseFragment;
import com.example.titshop.callback.ActionbarListener;
import com.example.titshop.callback.CartCallback;
import com.example.titshop.databinding.ActivityHomeBinding;
import com.example.titshop.fragment.explore.ExploreFragment;
import com.example.titshop.fragment.home.HomeFragment;
import com.example.titshop.fragment.product.ProductFragment;
import com.example.titshop.fragment.profile.ProfileFragment;
import com.example.titshop.fragment.shipping.ShippingFragment;
import com.example.titshop.fragment.wishlist.WishLishFragment;
import com.example.titshop.model.CartItem;
import com.example.titshop.model.Product;
import com.example.titshop.model.SubProduct;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.zip.Inflater;

public class HomeActivity extends BaseActivity<ActivityHomeBinding,HomeViewModel> implements ActionbarListener {
    RecyclerView recyclerViewCart;
    CartAdapter cartAdapter = new CartAdapter();

    @Override
    public Class<HomeViewModel> getViewmodel() {
        return HomeViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_home;
    }

    @Override
    public void setBindingViewmodel() {
       binding.setViewmodel(viewmodel);
       setuptToolbar();
        setUpNavigation();
         event();
    }

    private void setUpNavigation() {
        NavHostFragment navHostFragment =  (NavHostFragment)getSupportFragmentManager()
                .findFragmentById(R.id.nav_host);
        NavigationUI.setupWithNavController(binding.bottomNavigation,
                navHostFragment.getNavController());
    }

    private void setuptToolbar() {
        setSupportActionBar(binding.actionBar.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void event() {
        binding.actionBar.ivIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(HomeActivity.this, R.id.nav_host)
                        .navigateUp();
            }
        });
        binding.actionBar.ivCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               showCart();
            }
        });
        binding.actionBar.ivWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                rePlaceFragment(new WishLishFragment());
                Navigation.findNavController(HomeActivity.this, R.id.nav_host)
                        .navigate(R.id.wishLishFragment);
            }
        });
        binding.actionBar.ivMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "Click more", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onResumFragment(BaseFragment fragment) {
        if(fragment instanceof HomeFragment){
             binding.bottomNavigation.getMenu().findItem(R.id.navigationShop).setChecked(true);
             binding.actionBar.llFeature.setVisibility(View.VISIBLE);
             binding.actionBar.llNavigate.setVisibility(View.VISIBLE);
             binding.actionBar.title.setVisibility(View.VISIBLE);
             binding.actionBar.ivMore.setVisibility(View.GONE);
             binding.actionBar.ivWishlist.setVisibility(View.VISIBLE);
             binding.actionBar.ivIcon.setVisibility(View.GONE);
             binding.actionBar.title.setText("Shopping");
        }
        if(fragment instanceof ProductFragment){
            binding.actionBar.ivIcon.setVisibility(View.VISIBLE);
            binding.actionBar.llFeature.setVisibility(View.GONE);
            binding.actionBar.ivIcon.setImageResource(R.drawable.ic_chevron_left_black_24dp);
            binding.actionBar.title.setText("back");
        }
        if(fragment instanceof ExploreFragment){
            binding.bottomNavigation.getMenu().findItem(R.id.navigationExplore).setChecked(true);
            binding.actionBar.ivIcon.setVisibility(View.GONE);
            binding.actionBar.title.setVisibility(View.VISIBLE);
            binding.actionBar.title.setText("Explore");
            binding.actionBar.ivMore.setVisibility(View.GONE);
            binding.actionBar.llFeature.setVisibility(View.VISIBLE);
            binding.actionBar.ivWishlist.setVisibility(View.GONE);
            binding.actionBar.ivCart.setVisibility(View.VISIBLE);
        }
        if(fragment instanceof WishLishFragment){
            binding.actionBar.llFeature.setVisibility(View.GONE);
            binding.actionBar.ivIcon.setVisibility(View.VISIBLE);
            binding.actionBar.title.setVisibility(View.VISIBLE);
            binding.actionBar.title.setText("Wish list");
        }
        if(fragment instanceof ShippingFragment){
            binding.actionBar.llNavigate.setVisibility(View.VISIBLE);
            binding.actionBar.title.setVisibility(View.VISIBLE);
            binding.actionBar.title.setText("Checkout");
            binding.actionBar.ivIcon.setVisibility(View.VISIBLE);
            binding.actionBar.llFeature.setVisibility(View.GONE);
        }
        if(fragment instanceof ProfileFragment){
            binding.bottomNavigation.getMenu().findItem(R.id.navigationProfile).setChecked(true);
            binding.actionBar.llNavigate.setVisibility(View.VISIBLE);
            binding.actionBar.ivIcon.setVisibility(View.GONE);
            binding.actionBar.title.setVisibility(View.VISIBLE);
            binding.actionBar.title.setText("Profile");
            binding.actionBar.llFeature.setVisibility(View.VISIBLE);
            binding.actionBar.ivWishlist.setVisibility(View.VISIBLE);
            binding.actionBar.ivCart.setVisibility(View.VISIBLE);
        }
    }
    public void showCart(){
        final View view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_cart,null);
        // ánh xạ
        recyclerViewCart = (RecyclerView) view.findViewById(R.id.rvCart);
        Button btnCheckout = (Button) view.findViewById(R.id.btnCheckout);
        final TextView tvNumberitem =  (TextView) view.findViewById(R.id.tvNumberIteminCart) ;
        final TextView tvTotalMoney =  (TextView) view.findViewById(R.id.tvMonney) ;
        // set uprecyclerview

        recyclerViewCart.setHasFixedSize(true);
        recyclerViewCart.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewCart.setAdapter(cartAdapter);
        //get data
        final ArrayList<CartItem> arr = new ArrayList<>();

        arr.add(new CartItem(new Product(" Korean Style Women","https://my-test-11.slatic.net/p/7/kobwa-korean-style-women-fashion-casual-pu-leather-ladies-handbag-shoulder-bucket-tote-bag-brown-8138-099175611-084e0414bbec596b0199d890d826bd3b-.jpg_600x600q80.jpg","69","x","dress","99",4.5f),"XS","25"));
        arr.add(new CartItem(new Product("Bat sloweet wolan","https://ae01.alicdn.com/kf/HTB1DP_RXWSs3KVjSZPiq6AsiVXa5/2020-Plus-Size-Bat-Sleeved-Woolen-Coat-Scarf-Collar-Jackets-Women-Winter-Fashion-Outerwear-Thicker-Loose.jpg","24.47","x","dress","132",4.5f),"XL","2"));
        arr.add(new CartItem(new Product("T-shrit ladies","https://i.pinimg.com/736x/fc/07/d4/fc07d472f7a97762b5e2374446a8543f.jpg","24.89","x","x","23",4.5f),"M","20"));
        arr.add(new CartItem(new Product("Big Deal Kevin","https://ae01.alicdn.com/kf/HTB1MftjbdzvK1RkSnfoq6zMwVXan/KENVY-Brand-Fashion-Women-s-High-end-Luxury-Winter-Contrast-Color-Jacquard-Knitted-Cotton-Casual-Sweater.jpg","11.89","x","x","23",4.5f),"M","12"));

        cartAdapter.setList(arr);
        tvNumberitem.setText(arr.size() + " items");
        tvTotalMoney.setText(cartAdapter.getTotal());


        cartAdapter.setCallback(new CartCallback() {
            @Override
            public void ontang(CartItem cartItem) {
                int pos = cartAdapter.getList().indexOf(cartItem);
                cartItem.tang();
                cartAdapter.updateItem(pos,cartItem);
                tvTotalMoney.setText(cartAdapter.getTotal());
               // Toast.makeText(HomeActivity.this, "Tang " + cartItem.getProduct().getName() + " tại postition " + cartAdapter.getList().indexOf(cartItem) , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void ongiam(CartItem cartItem) {
                int pos = cartAdapter.getList().indexOf(cartItem);
                if(Integer.parseInt(cartItem.getNumberItem())>1){
                    cartItem.giam();
                    cartAdapter.updateItem(pos,cartItem);
                    tvTotalMoney.setText(cartAdapter.getTotal());
                }else{
                    cartAdapter.removeItem(pos);
                    tvTotalMoney.setText(cartAdapter.getTotal());
                    tvNumberitem.setText(cartAdapter.getList().size() + " items");
                }
            }

            @Override
            public void onProductClick(CartItem cartItem) {
                Toast.makeText(HomeActivity.this, "Click "  + cartItem.getProduct().getName(), Toast.LENGTH_SHORT).show();
            }
        });
        // get cart

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();
        // set actiom
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(HomeActivity.this, R.id.nav_host)
                        .navigate(R.id.shippingFragment);
                bottomSheetDialog.dismiss();
            }
        });
    }

}

