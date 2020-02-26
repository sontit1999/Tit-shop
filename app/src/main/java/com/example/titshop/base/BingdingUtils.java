package com.example.titshop.base;


import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


public class BingdingUtils {
    @BindingAdapter({ "setAdapter"})
    public static void setAdapter(RecyclerView view, RecyclerView.Adapter adapter) {
        view.setAdapter(adapter);
    }
    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide
                .with(view.getContext())
                .load(imageUrl)
                .into(view);

    }
    @BindingAdapter({"bind:monney"})
    public static void monney(TextView view, String monney) {
       view.setText("$" + monney);

    }
    @BindingAdapter({"bind:size"})
    public static void size(TextView view, String size) {
        view.setText("Size: " + size);

    }
    @BindingAdapter({"bind:imageUrlResize"})
    public static void loadImageResize(ImageView view, String imageUrl) {
        Glide
                .with(view.getContext())
                .load(imageUrl)
                .override(500,500)
                .into(view);

    }
}
