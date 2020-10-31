package com.example.titshop.adapter;

import com.example.titshop.BR;
import com.example.titshop.R;
import com.example.titshop.base.BaseAdapter;
import com.example.titshop.base.CBAdapter;
import com.example.titshop.callback.CagetoryCallback;
import com.example.titshop.databinding.ItemCagetoryBinding;
import com.example.titshop.model.Cagetory;

public class CagetoryAdapter extends BaseAdapter<Cagetory, ItemCagetoryBinding> {
    CagetoryCallback callback;
    public void setCallback(CagetoryCallback callback) {
        this.callback = callback;
    }
    @Override
    public int getLayoutId() {
        return R.layout.item_cagetory;
    }

    @Override
    public int getIdVariable() {
        return BR.cagetory;
    }

    @Override
    public int getIdVariableOnclick() {
        return BR.callback;
    }

    @Override
    public CBAdapter getOnclick() {
        return callback;
    }
}
