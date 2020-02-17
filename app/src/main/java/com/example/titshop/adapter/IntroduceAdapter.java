package com.example.titshop.adapter;

import com.example.titshop.BR;
import com.example.titshop.R;
import com.example.titshop.base.BaseAdapter;
import com.example.titshop.base.CBAdapter;
import com.example.titshop.databinding.ItemIntroduceBinding;
import com.example.titshop.model.Introduce;

public class IntroduceAdapter extends BaseAdapter<Introduce, ItemIntroduceBinding> {
    @Override
    public int getLayoutId() {
        return R.layout.item_introduce;
    }

    @Override
    public int getIdVariable() {
        return BR.introduce;
    }

    @Override
    public int getIdVariableOnclick() {
        return 0;
    }

    @Override
    public CBAdapter getOnclick() {
        return null;
    }
}
