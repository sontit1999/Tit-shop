package com.example.titshop.fragment.product;

import androidx.lifecycle.MutableLiveData;

import com.example.titshop.adapter.ProductAdapter;
import com.example.titshop.base.BaseViewmodel;
import com.example.titshop.model.SubProduct;

import java.util.ArrayList;

public class ProductFragViewModel extends BaseViewmodel {
    ProductAdapter ProductAdapter = new ProductAdapter();

    private MutableLiveData<ArrayList<SubProduct>> arrSubProductCollection = new MutableLiveData<>();

    public MutableLiveData<ArrayList<SubProduct>> getArrSubProductCollection() {
        ArrayList<SubProduct> arr = new ArrayList<>();
        arr.add(new SubProduct(" Korean Style Women", "https://my-test-11.slatic.net/p/7/kobwa-korean-style-women-fashion-casual-pu-leather-ladies-handbag-shoulder-bucket-tote-bag-brown-8138-099175611-084e0414bbec596b0199d890d826bd3b-.jpg_600x600q80.jpg", "$69", "x", "dress", true, 4.5f));
        arr.add(new SubProduct("Bat sloweet wolan", "https://ae01.alicdn.com/kf/HTB1DP_RXWSs3KVjSZPiq6AsiVXa5/2020-Plus-Size-Bat-Sleeved-Woolen-Coat-Scarf-Collar-Jackets-Women-Winter-Fashion-Outerwear-Thicker-Loose.jpg", "$24.47", "x", "dress", true, 4.5f));
        arr.add(new SubProduct("T-shrit ladies", "https://i.pinimg.com/736x/fc/07/d4/fc07d472f7a97762b5e2374446a8543f.jpg", "$24.89", "x", "x", true, 4.5f));
        arr.add(new SubProduct("Big Deal Kevin", "https://ae01.alicdn.com/kf/HTB1MftjbdzvK1RkSnfoq6zMwVXan/KENVY-Brand-Fashion-Women-s-High-end-Luxury-Winter-Contrast-Color-Jacquard-Knitted-Cotton-Casual-Sweater.jpg", "$11.89", "x", "x", true, 4.5f));
        arr.add(new SubProduct("Girl sweammer", "https://d2nikgq6rubtj8.cloudfront.net/web/2019/Sept/04/nav/womens-nav.jpg", "$12.94", "x", "x", true, 4.5f));
        arr.add(new SubProduct("Sustainable Women's Fashion", "https://ae01.alicdn.com/kf/HTB1YYlaPpXXXXX.XXXXq6xXFXXXx/Wanita-Piyama-Sutra-Celana-Pendek-Tombol-Lengan-Pendek-Kemeja-Dan-Pendek-Set-2016-Musim-Panas-Wanita.jpg", "$99", "x", "x", true, 4.5f));
        arr.add(new SubProduct(" Korean Style Women", "https://my-test-11.slatic.net/p/7/kobwa-korean-style-women-fashion-casual-pu-leather-ladies-handbag-shoulder-bucket-tote-bag-brown-8138-099175611-084e0414bbec596b0199d890d826bd3b-.jpg_600x600q80.jpg", "$69", "x", "dress", true, 4.5f));
        arr.add(new SubProduct("Bat sloweet wolan", "https://ae01.alicdn.com/kf/HTB1DP_RXWSs3KVjSZPiq6AsiVXa5/2020-Plus-Size-Bat-Sleeved-Woolen-Coat-Scarf-Collar-Jackets-Women-Winter-Fashion-Outerwear-Thicker-Loose.jpg", "$24.47", "x", "dress", true, 4.5f));
        arr.add(new SubProduct("T-shrit ladies", "https://i.pinimg.com/736x/fc/07/d4/fc07d472f7a97762b5e2374446a8543f.jpg", "$24.89", "x", "x", true, 4.5f));
        arr.add(new SubProduct("Big Deal Kevin", "https://ae01.alicdn.com/kf/HTB1MftjbdzvK1RkSnfoq6zMwVXan/KENVY-Brand-Fashion-Women-s-High-end-Luxury-Winter-Contrast-Color-Jacquard-Knitted-Cotton-Casual-Sweater.jpg", "$11.89", "x", "x", true, 4.5f));
        arr.add(new SubProduct("Girl sweammer", "https://d2nikgq6rubtj8.cloudfront.net/web/2019/Sept/04/nav/womens-nav.jpg", "$12.94", "x", "x", true, 4.5f));
        arr.add(new SubProduct("Sustainable Women's Fashion", "https://ae01.alicdn.com/kf/HTB1YYlaPpXXXXX.XXXXq6xXFXXXx/Wanita-Piyama-Sutra-Celana-Pendek-Tombol-Lengan-Pendek-Kemeja-Dan-Pendek-Set-2016-Musim-Panas-Wanita.jpg", "$99", "x", "x", true, 4.5f));
        arr.add(new SubProduct(" Korean Style Women", "https://my-test-11.slatic.net/p/7/kobwa-korean-style-women-fashion-casual-pu-leather-ladies-handbag-shoulder-bucket-tote-bag-brown-8138-099175611-084e0414bbec596b0199d890d826bd3b-.jpg_600x600q80.jpg", "$69", "x", "dress", true, 4.5f));
        arr.add(new SubProduct("Bat sloweet wolan", "https://ae01.alicdn.com/kf/HTB1DP_RXWSs3KVjSZPiq6AsiVXa5/2020-Plus-Size-Bat-Sleeved-Woolen-Coat-Scarf-Collar-Jackets-Women-Winter-Fashion-Outerwear-Thicker-Loose.jpg", "$24.47", "x", "dress", true, 4.5f));
        arr.add(new SubProduct("T-shrit ladies", "https://i.pinimg.com/736x/fc/07/d4/fc07d472f7a97762b5e2374446a8543f.jpg", "$24.89", "x", "x", true, 4.5f));
        arr.add(new SubProduct("Big Deal Kevin", "https://ae01.alicdn.com/kf/HTB1MftjbdzvK1RkSnfoq6zMwVXan/KENVY-Brand-Fashion-Women-s-High-end-Luxury-Winter-Contrast-Color-Jacquard-Knitted-Cotton-Casual-Sweater.jpg", "$11.89", "x", "x", true, 4.5f));
        arr.add(new SubProduct("Girl sweammer", "https://d2nikgq6rubtj8.cloudfront.net/web/2019/Sept/04/nav/womens-nav.jpg", "$12.94", "x", "x", true, 4.5f));
        arr.add(new SubProduct("Sustainable Women's Fashion", "https://ae01.alicdn.com/kf/HTB1YYlaPpXXXXX.XXXXq6xXFXXXx/Wanita-Piyama-Sutra-Celana-Pendek-Tombol-Lengan-Pendek-Kemeja-Dan-Pendek-Set-2016-Musim-Panas-Wanita.jpg", "$99", "x", "x", true, 4.5f));
        arrSubProductCollection.postValue(arr);
        return arrSubProductCollection;
    }
}
