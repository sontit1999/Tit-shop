package com.example.titshop.fragment.home;

import androidx.lifecycle.MutableLiveData;

import com.example.titshop.adapter.CollectionAdapter;
import com.example.titshop.adapter.TopTrendAdapter;
import com.example.titshop.base.BaseViewmodel;
import com.example.titshop.model.Product;
import com.example.titshop.model.SliderItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HomeFragViewModel extends BaseViewmodel {
     CollectionAdapter CollectionAdapter = new CollectionAdapter();
     TopTrendAdapter ToptrendAdapter = new TopTrendAdapter();
     private MutableLiveData<List<SliderItem>> arrSildeItem = new MutableLiveData<>();
     private MutableLiveData<ArrayList<Product>> arrProductCollection = new MutableLiveData<>();
     private MutableLiveData<ArrayList<Product>> arrProductToptrend = new MutableLiveData<>();
     public MutableLiveData<List<SliderItem>> getArrItem(){
         List<SliderItem> arr = new ArrayList<>();
         arr.add(new SliderItem("Đang giảm giá nè . Mua đi !!!","https://khoedep24gio.com/wp-content/uploads/2019/06/shop-ban-ao-doi-dep-o-ha-noi-baduy-shop-2.png"));
         arr.add(new SliderItem("Đang giảm giá nè . Mua đi !!!","https://bizweb.dktcdn.net/100/104/183/products/quan-tay-baggy-ngan-hong.png?v=1470410349437"));
         arr.add(new SliderItem("Đang giảm giá nè . Mua đi !!!","https://r8zlusvr.rocketcdn.com/templates/selectfashion.co.uk.new/assets/images/home/main-page-pods/pod1a-coats111.jpg"));
         arr.add(new SliderItem("Đang giảm giá nè . Mua đi !!!","https://iqueenfashion.vn/uploads/98/637081193496541818-DSC09555.jpg"));
         arrSildeItem.postValue(arr);
         return arrSildeItem;
     }
     public MutableLiveData<ArrayList<Product>> getArrCollection(){
         ArrayList<Product> arr = new ArrayList<>();
         arr.add(new Product(" Korean Style Women","https://my-test-11.slatic.net/p/7/kobwa-korean-style-women-fashion-casual-pu-leather-ladies-handbag-shoulder-bucket-tote-bag-brown-8138-099175611-084e0414bbec596b0199d890d826bd3b-.jpg_600x600q80.jpg","$69","x","dress","99",4.5f));
         arr.add(new Product("Bat sloweet wolan","https://ae01.alicdn.com/kf/HTB1DP_RXWSs3KVjSZPiq6AsiVXa5/2020-Plus-Size-Bat-Sleeved-Woolen-Coat-Scarf-Collar-Jackets-Women-Winter-Fashion-Outerwear-Thicker-Loose.jpg","$24.47","x","dress","132",4.5f));
         arr.add(new Product("T-shrit ladies","https://i.pinimg.com/736x/fc/07/d4/fc07d472f7a97762b5e2374446a8543f.jpg","$24.89","x","x","23",4.5f));
         arr.add(new Product("Big Deal Kevin","https://ae01.alicdn.com/kf/HTB1MftjbdzvK1RkSnfoq6zMwVXan/KENVY-Brand-Fashion-Women-s-High-end-Luxury-Winter-Contrast-Color-Jacquard-Knitted-Cotton-Casual-Sweater.jpg","$11.89","x","x","23",4.5f));
         arr.add(new Product("Girl sweammer","https://d2nikgq6rubtj8.cloudfront.net/web/2019/Sept/04/nav/womens-nav.jpg","$12.94","x","x","56",4.5f));
         arr.add(new Product("Sustainable Women's Fashion xxxxxxxxxxxxxxxxxxxxxxxxxx","https://ae01.alicdn.com/kf/HTB1YYlaPpXXXXX.XXXXq6xXFXXXx/Wanita-Piyama-Sutra-Celana-Pendek-Tombol-Lengan-Pendek-Kemeja-Dan-Pendek-Set-2016-Musim-Panas-Wanita.jpg","$99","x","x","96",4.5f));
         arrProductCollection.postValue(arr);
         return arrProductCollection;
     }
    public MutableLiveData<ArrayList<Product>> getArrToptrend(){
        ArrayList<Product> arr = new ArrayList<>();
        arr.add(new Product(" Korean Style Women","https://my-test-11.slatic.net/p/7/kobwa-korean-style-women-fashion-casual-pu-leather-ladies-handbag-shoulder-bucket-tote-bag-brown-8138-099175611-084e0414bbec596b0199d890d826bd3b-.jpg_600x600q80.jpg","$69","x","dress","99",4.5f));
        arr.add(new Product("Bat sloweet wolan","https://ae01.alicdn.com/kf/HTB1DP_RXWSs3KVjSZPiq6AsiVXa5/2020-Plus-Size-Bat-Sleeved-Woolen-Coat-Scarf-Collar-Jackets-Women-Winter-Fashion-Outerwear-Thicker-Loose.jpg","$24.47","x","dress","132",4.5f));
        arr.add(new Product("T-shrit ladies","https://i.pinimg.com/736x/fc/07/d4/fc07d472f7a97762b5e2374446a8543f.jpg","$24.89","x","x","23",4.5f));
        arr.add(new Product("Big Deal Kevin","https://ae01.alicdn.com/kf/HTB1MftjbdzvK1RkSnfoq6zMwVXan/KENVY-Brand-Fashion-Women-s-High-end-Luxury-Winter-Contrast-Color-Jacquard-Knitted-Cotton-Casual-Sweater.jpg","$11.89","x","x","23",4.5f));
        arr.add(new Product("Girl sweammer","https://d2nikgq6rubtj8.cloudfront.net/web/2019/Sept/04/nav/womens-nav.jpg","$12.94","x","x","56",4.5f));
        arr.add(new Product("Sustainable Women's Fashion xxxxxxxxxxxxxxxxxxxxxx","https://ae01.alicdn.com/kf/HTB1YYlaPpXXXXX.XXXXq6xXFXXXx/Wanita-Piyama-Sutra-Celana-Pendek-Tombol-Lengan-Pendek-Kemeja-Dan-Pendek-Set-2016-Musim-Panas-Wanita.jpg","$99","x","x","96",4.5f));
        Collections.shuffle(arr);
        arrProductToptrend.postValue(arr);
        return arrProductToptrend;
    }
}
