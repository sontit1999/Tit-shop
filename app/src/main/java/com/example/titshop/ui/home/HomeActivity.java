package com.example.titshop.ui.home;

import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.titshop.R;
import com.example.titshop.base.BaseActivity;
import com.example.titshop.databinding.ActivityHomeBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.zip.Inflater;

public class HomeActivity extends BaseActivity<ActivityHomeBinding,HomeViewModel> {
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
       event();

    }

    private void setuptToolbar() {
        setSupportActionBar(binding.actionBar.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_more_horiz_black_24dp);
//        binding.actionBar.toolbar.setOverflowIcon(drawable);
    }

    private void event() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigationShop:
                        hiddenIconback();
                        Toast.makeText(HomeActivity.this, "click shop", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigationExplore:
                        hiddenIconback();
                        Toast.makeText(HomeActivity.this, "click Explore", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigationNotification:
                        Toast.makeText(HomeActivity.this, "click Notification", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigationProfile:
                        Toast.makeText(HomeActivity.this, "click Profile", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
        binding.actionBar.ivIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "Click icon back", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void hiddenIconback() {
        binding.actionBar.ivIcon.setVisibility(View.GONE);
        binding.actionBar.title.setVisibility(View.GONE);
        binding.actionBar.toolbar.getMenu().findItem(R.id.menuMore).setVisible(false);
    }
    private void showIconback() {
        binding.actionBar.ivIcon.setVisibility(View.VISIBLE);
        binding.actionBar.title.setVisibility(View.VISIBLE);
    }
    public void rePlaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuFavorite:
                Toast.makeText(this, "Click favorite", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuCart:
                Toast.makeText(this, "Click Cart", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuMore:
                Toast.makeText(this, "Click More", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
