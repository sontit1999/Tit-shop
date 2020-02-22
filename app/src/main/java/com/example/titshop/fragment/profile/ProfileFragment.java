package com.example.titshop.fragment.profile;

import com.example.titshop.R;
import com.example.titshop.base.BaseFragment;
import com.example.titshop.databinding.FragProfileBinding;

public class ProfileFragment extends BaseFragment<FragProfileBinding,ProfileViewModel> {
    @Override
    public Class<ProfileViewModel> getViewmodel() {
        return ProfileViewModel.class;
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
}
