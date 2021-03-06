package com.example.titshop.base;


import android.content.res.ColorStateList;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.titshop.R;


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
    @BindingAdapter({"bind:islike"})
    public static void islike(ImageView view, String idProduct) {
        if(idProduct.equals("y")){
            ImageViewCompat.setImageTintList(view, ColorStateList.valueOf(ContextCompat.getColor(view.getContext(), R.color.colorRed)));
        }
    }
    @BindingAdapter({"bind:size"})
    public static void size(TextView view, String size) {
        view.setText("Size: " + size);

    }
    @BindingAdapter({"bind:discount"})
    public static void loadDiscount(TextView view, String discount) {
        view.setText("Giảm\n" + discount);
        view.setGravity(Gravity.CENTER);
    }
    @BindingAdapter({"bind:numberSale"})
    public static void loadNumberSale(TextView view, String numberSale) {
        view.setText("Đã bán " + numberSale);
        view.setGravity(Gravity.CENTER);
    }
    @BindingAdapter({"bind:Price"})
    public static void loadPrice(TextView view, String Price) {
        view.setText( Price + " đ");
        view.setGravity(Gravity.CENTER);
    }
    @BindingAdapter({"bind:PriceCart"})
    public static void loadPriceCart(TextView view, String PriceCart) {
        view.setText( PriceCart + " đ");
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
