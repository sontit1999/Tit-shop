package com.example.titshop.callback;

import com.example.titshop.base.BaseFragment;
import com.example.titshop.fragment.Fragment;

public interface ActionbarListener {
    void onResumFragment(BaseFragment fragment);
    void onViewFragment();
    void onBoughtFragment();
    void onWaitFragment();
    void onLikeFragment();
}
