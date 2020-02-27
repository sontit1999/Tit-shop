package com.example.titshop.fragment.review;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.titshop.R;
import com.example.titshop.base.BaseFragment;
import com.example.titshop.databinding.FragReviewBinding;
import com.example.titshop.model.Comment;

import java.util.ArrayList;

public class ReviewFragment extends BaseFragment<FragReviewBinding,ReviewViewModel> {
    @Override
    public Class<ReviewViewModel> getViewmodel() {
        return ReviewViewModel.class;
    }

    @Override
    public int getLayoutID() {
        return R.layout.frag_review;
    }

    @Override
    public void setBindingViewmodel() {
         binding.setViewmodel(viewmodel);
         setupRecyclerview();
    }

    private void setupRecyclerview() {
        // init recyclerview collection
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        binding.rvReview.setHasFixedSize(true);
        binding.rvReview.setLayoutManager(layoutManager);
        binding.rvReview.setAdapter(viewmodel.commentAdapter);
    }

    @Override
    public void ViewCreated() {
        viewmodel.getArrComment().observe(this, new Observer<ArrayList<Comment>>() {
            @Override
            public void onChanged(ArrayList<Comment> comments) {
                viewmodel.commentAdapter.setList(comments);
            }
        });
    }
}
