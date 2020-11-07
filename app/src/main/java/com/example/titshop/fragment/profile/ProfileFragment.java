package com.example.titshop.fragment.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.titshop.R;
import com.example.titshop.base.BaseFragment;
import com.example.titshop.callback.ActionbarListener;
import com.example.titshop.databinding.FragProfileBinding;
import com.example.titshop.model.SingleTonUser;
import com.example.titshop.ui.home.HomeActivity;
import com.example.titshop.ui.login.LoginActivity;
import com.example.titshop.ultis.Constant;

public class ProfileFragment extends BaseFragment<FragProfileBinding,ProfileViewModel> {
    ActionbarListener listener;
    @Override
    public Class<ProfileViewModel> getViewmodel() {
        return ProfileViewModel.class;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (ActionbarListener) context;
    }

    @Override
    public int getLayoutID() {
        return R.layout.frag_profile;
    }

    @Override
    public void setBindingViewmodel() {
          binding.setViewmodel(viewmodel);
    }

    @Override
    public void ViewCreated() {
        Glide.with(getContext()).load("https://media.ex-cdn.com/EXP/media.phatgiao.org.vn/files/f1/Contents/nguyenlinhchi/20161027/Phatgiao-org-vn-Phatdaychantrau.jpg").into(binding.ivCover);
        Glide.with(getContext()).load("https://i.pinimg.com/originals/82/49/22/824922ef9208b68312a930256116dd5c.jpg").into(binding.ivAvatar);
        bindUser();
        event();
    }

    private void event() {
       binding.btnBought.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Bundle bundle = new Bundle();
               bundle.putString("type", Constant.typeBought);
               Navigation.findNavController(getActivity(), R.id.nav_host)
                       .navigate(R.id.wishLishFragment,bundle);
               listener.onBoughtFragment();
           }
       });
       binding.btnLike.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               listener.onLikeFragment();
               Bundle bundle = new Bundle();
               bundle.putString("type", Constant.typeLike);
               Navigation.findNavController(getActivity(), R.id.nav_host)
                       .navigate(R.id.wishLishFragment,bundle);

           }
       });
       binding.btnWait.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               listener.onWaitFragment();
               Bundle bundle = new Bundle();
               bundle.putString("type", Constant.typeWait);
               Navigation.findNavController(getActivity(), R.id.nav_host)
                       .navigate(R.id.wishLishFragment,bundle);

           }
       });
       binding.btnView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               listener.onViewFragment();
               Bundle bundle = new Bundle();
               bundle.putString("type", Constant.typeView);
               Navigation.findNavController(getActivity(), R.id.nav_host)
                       .navigate(R.id.wishLishFragment,bundle);

           }
       });
       binding.btnLogout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(getContext(), LoginActivity.class);
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
               getContext().startActivity(intent);
           }
       });
    }

    private void bindUser() {
        if(SingleTonUser.user!=null){
            binding.tvUsername.setText(SingleTonUser.user.getUsername());
            Glide.with(getContext()).load(SingleTonUser.user.getLinkavatar()).apply(new RequestOptions().override(500, 500)).into(binding.ivAvatar);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        listener.onResumFragment(this);
    }
}
