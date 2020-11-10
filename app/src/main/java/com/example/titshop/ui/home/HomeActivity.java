package com.example.titshop.ui.home;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
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
import androidx.appcompat.app.ActionBar;
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
import com.example.titshop.fragment.detailproduct.DetailFragment;
import com.example.titshop.fragment.explore.ExploreFragment;
import com.example.titshop.fragment.home.HomeFragment;
import com.example.titshop.fragment.product.ProductFragment;
import com.example.titshop.fragment.profile.ProfileFragment;
import com.example.titshop.fragment.shipping.ShippingFragment;
import com.example.titshop.fragment.wishlist.WishLishFragment;
import com.example.titshop.model.CartItem;
import com.example.titshop.model.Product;
import com.example.titshop.model.SubProduct;
import com.example.titshop.roomdb.CartDAO;
import com.example.titshop.ultis.Constant;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.zip.Inflater;

public class HomeActivity extends BaseActivity<ActivityHomeBinding,HomeViewModel> implements ActionbarListener {
    RecyclerView recyclerViewCart;
    CartAdapter cartAdapter = new CartAdapter();
    CartDAO cartDAO = null;
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
       initRoomDatabase();
       setuptToolbar();
       changeColor(R.color.colorMain);
        setUpNavigation();
         event();
         // test writo to database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello, World!");
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
    public void changeColor(int resourseColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), resourseColor));
        }

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(resourseColor)));

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
                Bundle bundle = new Bundle();
                bundle.putString("type", Constant.typeLike);
                Navigation.findNavController(HomeActivity.this, R.id.nav_host)
                        .navigate(R.id.wishLishFragment,bundle);
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
             binding.bottomNavigation.setVisibility(View.VISIBLE);
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
            binding.bottomNavigation.setVisibility(View.VISIBLE);
            binding.actionBar.ivIcon.setVisibility(View.VISIBLE);
            binding.actionBar.llFeature.setVisibility(View.GONE);
            binding.actionBar.ivIcon.setImageResource(R.drawable.ic_chevron_left_black_24dp);
            binding.actionBar.title.setText("back");
        }
        if(fragment instanceof ExploreFragment){
            binding.bottomNavigation.setVisibility(View.VISIBLE);
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
            binding.bottomNavigation.setVisibility(View.VISIBLE);
            binding.actionBar.llFeature.setVisibility(View.GONE);
            binding.actionBar.ivIcon.setVisibility(View.VISIBLE);
            binding.actionBar.title.setVisibility(View.VISIBLE);
            binding.actionBar.title.setText("Wish list");
        }
        if(fragment instanceof ShippingFragment){
            binding.bottomNavigation.setVisibility(View.GONE);
            binding.actionBar.llNavigate.setVisibility(View.VISIBLE);
            binding.actionBar.title.setVisibility(View.VISIBLE);
            binding.actionBar.title.setText("Checkout");
            binding.actionBar.ivIcon.setVisibility(View.VISIBLE);
            binding.actionBar.llFeature.setVisibility(View.GONE);
        }
        if(fragment instanceof ProfileFragment){
            binding.bottomNavigation.setVisibility(View.VISIBLE);
            binding.bottomNavigation.getMenu().findItem(R.id.navigationProfile).setChecked(true);
            binding.actionBar.llNavigate.setVisibility(View.VISIBLE);
            binding.actionBar.ivIcon.setVisibility(View.GONE);
            binding.actionBar.title.setVisibility(View.VISIBLE);
            binding.actionBar.title.setText("Profile");
            binding.actionBar.llFeature.setVisibility(View.VISIBLE);
            binding.actionBar.ivWishlist.setVisibility(View.INVISIBLE);
            binding.actionBar.ivCart.setVisibility(View.VISIBLE);
        }
        if(fragment instanceof DetailFragment){
            binding.bottomNavigation.setVisibility(View.GONE);
            binding.actionBar.llFeature.setVisibility(View.VISIBLE);
            binding.actionBar.ivCart.setVisibility(View.VISIBLE);
            binding.actionBar.ivWishlist.setVisibility(View.VISIBLE);
            binding.actionBar.ivMore.setVisibility(View.GONE);
            binding.actionBar.ivIcon.setVisibility(View.VISIBLE);
            binding.actionBar.title.setVisibility(View.VISIBLE);
            binding.actionBar.title.setText("Back");
        }
    }

    @Override
    public void onViewFragment() {
        binding.actionBar.title.setText("Sản phẩm đã xem");
    }

    @Override
    public void onBoughtFragment() {
        binding.actionBar.title.setText("Sản phẩm đã mua");
    }

    @Override
    public void onWaitFragment() {
        binding.actionBar.title.setText("Sản phẩm đang chờ");
    }

    @Override
    public void onLikeFragment() {
        binding.actionBar.title.setText("Sản phẩm đã thích");
    }
    private void initRoomDatabase() {
        Constant.initDatabase(HomeActivity.this);
        cartDAO = Constant.getDatabase().getCartDao();
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
        final ArrayList<CartItem> arr = (ArrayList<CartItem>) cartDAO.getAllCart() ;
        Collections.reverse(arr);
        cartAdapter.setList(arr);
        tvNumberitem.setText(arr.size() + " items");
        tvTotalMoney.setText(cartAdapter.getTotal());


        cartAdapter.setCallback(new CartCallback() {
            @Override
            public void ontang(CartItem cartItem) {
                int pos = cartAdapter.getList().indexOf(cartItem);
                cartItem.tang();
                cartDAO.update(cartItem);
                cartAdapter.updateItem(pos,cartItem);
                tvTotalMoney.setText(cartAdapter.getTotal());
            }

            @Override
            public void ongiam(CartItem cartItem) {
                int pos = cartAdapter.getList().indexOf(cartItem);
                if(Integer.parseInt(cartItem.getNumberItem())>1){
                    cartItem.giam();
                    cartAdapter.updateItem(pos,cartItem);
                    cartDAO.update(cartItem);
                    tvTotalMoney.setText(cartAdapter.getTotal());
                }else{
                    cartDAO.delete(cartItem);
                    cartAdapter.removeItem(pos);
                    tvTotalMoney.setText(cartAdapter.getTotal());
                    tvNumberitem.setText(cartAdapter.getList().size() + " items");
                }
            }

            @Override
            public void onProductClick(CartItem cartItem) {
                Toast.makeText(HomeActivity.this, "Click "  + cartItem.getName(), Toast.LENGTH_SHORT).show();
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

