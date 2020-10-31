package com.example.titshop.fragment.home;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.titshop.adapter.CagetoryAdapter;
import com.example.titshop.adapter.CollectionAdapter;
import com.example.titshop.adapter.FlashSaleAdapter;
import com.example.titshop.adapter.ProductAdapter;
import com.example.titshop.adapter.TopTrendAdapter;
import com.example.titshop.api.RetrofitClient;
import com.example.titshop.api.ShoppeService;
import com.example.titshop.base.BaseViewmodel;
import com.example.titshop.model.Cagetory;
import com.example.titshop.model.Product;
import com.example.titshop.model.SliderItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragViewModel extends BaseViewmodel {
     CollectionAdapter CollectionAdapter = new CollectionAdapter();
     TopTrendAdapter ToptrendAdapter = new TopTrendAdapter();
     CagetoryAdapter cagetoryAdapter = new CagetoryAdapter();
     FlashSaleAdapter flashSaleAdapter = new FlashSaleAdapter();
    ProductAdapter productAdapter = new ProductAdapter();
    MutableLiveData<List<Product>> arrRecomendProduct = new MutableLiveData<>();
     private MutableLiveData<List<SliderItem>> arrSildeItem = new MutableLiveData<>();
     private MutableLiveData<ArrayList<Product>> arrProductCollection = new MutableLiveData<>();
     private MutableLiveData<ArrayList<Product>> arrProductToptrend = new MutableLiveData<>();
    MutableLiveData<List<Product>> arrFlashSale = new MutableLiveData<>();
    MutableLiveData<List<Cagetory>> arrCagetory = new MutableLiveData<>();
    public MutableLiveData<List<Product>> getArrRecomendProduct(Context context) {
        ShoppeService shoppeService = RetrofitClient.getInstance(context).create(ShoppeService.class);
        Call<List<Product>> call = shoppeService.getRecomendProduct();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                arrRecomendProduct.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(context, "call api fail: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return arrRecomendProduct;
    }
     public MutableLiveData<List<SliderItem>> getArrItem(){
         List<SliderItem> arr = new ArrayList<>();
//         arr.add(new SliderItem("Đang giảm giá nè . Mua đi !!!","https://khoedep24gio.com/wp-content/uploads/2019/06/shop-ban-ao-doi-dep-o-ha-noi-baduy-shop-2.png"));
//         arr.add(new SliderItem("Đang giảm giá nè . Mua đi !!!","https://bizweb.dktcdn.net/100/104/183/products/quan-tay-baggy-ngan-hong.png?v=1470410349437"));
//         arr.add(new SliderItem("Đang giảm giá nè . Mua đi !!!","https://r8zlusvr.rocketcdn.com/templates/selectfashion.co.uk.new/assets/images/home/main-page-pods/pod1a-coats111.jpg"));
//         arr.add(new SliderItem("Đang giảm giá nè . Mua đi !!!","https://iqueenfashion.vn/uploads/98/637081193496541818-DSC09555.jpg"));

         arr.add(new SliderItem("Đang giảm giá nè . Mua đi !!!","https://cf.shopee.vn/file/67e108f93ec4f9caa5fe4fb1853fc7e9"));
         arr.add(new SliderItem("Đang giảm giá nè . Mua đi !!!","https://magiamgiashopee.com/wp-content/uploads/2020/02/shopee-sieu-sale-11-11-1024x535-1.jpg"));
         arr.add(new SliderItem("Đang giảm giá nè . Mua đi !!!","https://magiamgiashopee.vn/wp-content/uploads/2019/07/Si%C3%AAu-Sale-Freeship-Shopee.png.webp"));
         arr.add(new SliderItem("Đang giảm giá nè . Mua đi !!!","https://cdn.chanhtuoi.com/uploads/2019/10/11-11-shopee-sieu-sale-01.jpg"));
         arr.add(new SliderItem("Đang giảm giá nè . Mua đi !!!","https://muaodau.pro/wp-content/uploads/2019/11/shopee_02.11_3.jpg"));
         arr.add(new SliderItem("Đang giảm giá nè . Mua đi !!!","https://saigonbiz.com.vn/wp-content/uploads/2018/11/Dai-tiec-mua-sam-lazada.jpg"));
         arr.add(new SliderItem("Đang giảm giá nè . Mua đi !!!","https://bloggiamgia.vn/wp-content/uploads/2018/10/Lazada-khuy%E1%BA%BFn-m%C3%A3i-11-11.png.webp"));
         arrSildeItem.postValue(arr);
         return arrSildeItem;
     }
    public MutableLiveData<List<Product>> getArrFlashSale(Context context) {

        ShoppeService shoppeService = RetrofitClient.getInstance(context).create(ShoppeService.class);
        Call<List<Product>> call = shoppeService.getSaleProduct();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                arrFlashSale.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(context, "call api fail: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return arrFlashSale;
    }
     public MutableLiveData<ArrayList<Product>> getArrCollection(){
         ArrayList<Product> arr = new ArrayList<>();
         arr.add(new Product(" Korean Style Women","https://my-test-11.slatic.net/p/7/kobwa-korean-style-women-fashion-casual-pu-leather-ladies-handbag-shoulder-bucket-tote-bag-brown-8138-099175611-084e0414bbec596b0199d890d826bd3b-.jpg_600x600q80.jpg","$69","x","dress","99","4"));
         arr.add(new Product("Bat sloweet wolan","https://ae01.alicdn.com/kf/HTB1DP_RXWSs3KVjSZPiq6AsiVXa5/2020-Plus-Size-Bat-Sleeved-Woolen-Coat-Scarf-Collar-Jackets-Women-Winter-Fashion-Outerwear-Thicker-Loose.jpg","$24.47","x","dress","132","4"));
         arr.add(new Product("T-shrit ladies","https://i.pinimg.com/736x/fc/07/d4/fc07d472f7a97762b5e2374446a8543f.jpg","$24.89","x","x","23","4"));
         arr.add(new Product("Big Deal Kevin","https://ae01.alicdn.com/kf/HTB1MftjbdzvK1RkSnfoq6zMwVXan/KENVY-Brand-Fashion-Women-s-High-end-Luxury-Winter-Contrast-Color-Jacquard-Knitted-Cotton-Casual-Sweater.jpg","$11.89","x","x","23","4"));
         arr.add(new Product("Girl sweammer","https://d2nikgq6rubtj8.cloudfront.net/web/2019/Sept/04/nav/womens-nav.jpg","$12.94","x","x","56","4"));
         arr.add(new Product("Sustainable Women's Fashion xxxxxxxxxxxxxxxxxxxxxxxxxx","https://ae01.alicdn.com/kf/HTB1YYlaPpXXXXX.XXXXq6xXFXXXx/Wanita-Piyama-Sutra-Celana-Pendek-Tombol-Lengan-Pendek-Kemeja-Dan-Pendek-Set-2016-Musim-Panas-Wanita.jpg","$99","x","x","96","4"));
         arrProductCollection.postValue(arr);
         return arrProductCollection;
     }
    public MutableLiveData<ArrayList<Product>> getArrToptrend(){
        ArrayList<Product> arr = new ArrayList<>();
        arr.add(new Product(" Korean Style Women","https://my-test-11.slatic.net/p/7/kobwa-korean-style-women-fashion-casual-pu-leather-ladies-handbag-shoulder-bucket-tote-bag-brown-8138-099175611-084e0414bbec596b0199d890d826bd3b-.jpg_600x600q80.jpg","$69","x","dress","99","4"));
        arr.add(new Product("Bat sloweet wolan","https://ae01.alicdn.com/kf/HTB1DP_RXWSs3KVjSZPiq6AsiVXa5/2020-Plus-Size-Bat-Sleeved-Woolen-Coat-Scarf-Collar-Jackets-Women-Winter-Fashion-Outerwear-Thicker-Loose.jpg","$24.47","x","dress","132","4"));
        arr.add(new Product("T-shrit ladies","https://i.pinimg.com/736x/fc/07/d4/fc07d472f7a97762b5e2374446a8543f.jpg","$24.89","x","x","23","4"));
        arr.add(new Product("Big Deal Kevin","https://ae01.alicdn.com/kf/HTB1MftjbdzvK1RkSnfoq6zMwVXan/KENVY-Brand-Fashion-Women-s-High-end-Luxury-Winter-Contrast-Color-Jacquard-Knitted-Cotton-Casual-Sweater.jpg","$11.89","x","x","23","4"));
        arr.add(new Product("Girl sweammer","https://d2nikgq6rubtj8.cloudfront.net/web/2019/Sept/04/nav/womens-nav.jpg","$12.94","x","x","56","4"));
        arr.add(new Product("Sustainable Women's Fashion xxxxxxxxxxxxxxxxxxxxxx","https://ae01.alicdn.com/kf/HTB1YYlaPpXXXXX.XXXXq6xXFXXXx/Wanita-Piyama-Sutra-Celana-Pendek-Tombol-Lengan-Pendek-Kemeja-Dan-Pendek-Set-2016-Musim-Panas-Wanita.jpg","$99","x","x","96","4"));
        Collections.shuffle(arr);
        arrProductToptrend.postValue(arr);
        return arrProductToptrend;
    }
    public MutableLiveData<List<Cagetory>> getArrCagetory(Context context) {
        ShoppeService shoppeService = RetrofitClient.getInstance(context).create(ShoppeService.class);
        Call<List<Cagetory>> call = shoppeService.getCagetory();
        call.enqueue(new Callback<List<Cagetory>>() {
            @Override
            public void onResponse(Call<List<Cagetory>> call, Response<List<Cagetory>> response) {
                arrCagetory.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Cagetory>> call, Throwable t) {
                Toast.makeText(context, "call api fail: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return arrCagetory;
    }
}
