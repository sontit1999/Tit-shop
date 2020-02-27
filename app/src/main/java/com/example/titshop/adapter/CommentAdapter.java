package com.example.titshop.adapter;

import com.example.titshop.BR;
import com.example.titshop.R;
import com.example.titshop.base.BaseAdapter;
import com.example.titshop.base.CBAdapter;
import com.example.titshop.databinding.ItemCommentBinding;
import com.example.titshop.model.Comment;

public class CommentAdapter extends BaseAdapter<Comment, ItemCommentBinding> {
    @Override
    public int getLayoutId() {
        return R.layout.item_comment;
    }

    @Override
    public int getIdVariable() {
        return BR.comment;
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
