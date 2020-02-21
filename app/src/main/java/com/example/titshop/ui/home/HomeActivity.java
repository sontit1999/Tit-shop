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
import com.example.titshop.base.BaseFragment;
import com.example.titshop.callback.ActionbarListener;
import com.example.titshop.databinding.ActivityHomeBinding;
import com.example.titshop.fragment.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.zip.Inflater;

public class HomeActivity extends BaseActivity<ActivityHomeBinding,HomeViewModel> implements ActionbarListener {
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
       // load default fragment
        rePlaceFragment(new HomeFragment());
    }

    private void setuptToolbar() {
        setSupportActionBar(binding.actionBar.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void event() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigationShop:
                        hiddenMore();
                        rePlaceFragment(new HomeFragment());
                        break;
                    case R.id.navigationExplore:
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

    private void hiddenMore() {
        binding.actionBar.toolbar.getMenu().findItem(R.id.menuMore).setVisible(false);
    }
    private void ShowMore() {
        binding.actionBar.toolbar.getMenu().findItem(R.id.menuMore).setVisible(true);
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
        hiddenMore();
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

    @Override
    public void onResumFragment(BaseFragment fragment) {
        if(fragment instanceof HomeFragment){
             binding.actionBar.ivIcon.setVisibility(View.GONE);
             binding.actionBar.title.setText("Shopping");
        }

    }
}
