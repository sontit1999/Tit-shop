package com.example.titshop.fragment.profile;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.titshop.R;
import com.example.titshop.base.BaseFragment;
import com.example.titshop.callback.ActionbarListener;
import com.example.titshop.databinding.FragProfileBinding;

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

    }

    @Override
    public void onResume() {
        super.onResume();
        listener.onResumFragment(this);
    }
}
