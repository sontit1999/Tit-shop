package com.example.titshop.api;


import com.example.titshop.model.Cagetory;
import com.example.titshop.model.CommentResponse;
import com.example.titshop.model.Product;
import com.example.titshop.model.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShoppeService {
      // get danh mục
      @GET("getCagetory.php")
      Call<List<Cagetory>> getCagetory();
      // get all san pham
      @GET("getProduct.php")
      Call<List<Product>> getAllProduct();
      // get recomend san pham
      @GET("getProductRecomend.php")
      Call<List<Product>> getRecomendProduct();
      // get san pham sale
      @GET("getProductSale.php")
      Call<List<Product>> getSaleProduct();

      // get all recomend san pham
      @GET("getAllRecomend.php")
      Call<List<Product>> getAllRecomendProduct();
      // get all san pham sale
      @GET("getAllProductSale.php")
      Call<List<Product>> getAllSaleProduct();

      // get all san pham theo type
      @GET("getProductByType.php")
      Call<List<Product>> getProductByType(@Query("idtype") int idtype);
      // login
      @GET("login.php")
      Call<UserResponse> CheckLogin(@Query("sdt") String sdt, @Query("pass") String pass);
      // register
      @GET("register.php")
      Call<String> Register(@Query("username") String username, @Query("sdt") String sdt, @Query("password") String password, @Query("linkavatar") String linkavatar, @Query("address") String address);
      // get all comment san pham theo id
      @GET("getCommentProduct.php")
      Call<List<CommentResponse>> getCommentProductByID(@Query("idproduct") int idproduct);
      // add comment san pham
      @GET("addComment.php")
      Call<String> AddCommentProduct(@Query("iduser") int iduser, @Query("idproduct") int idproduct, @Query("content") String content);
      // add comment san pham
      @GET("adddonhang.php")
      Call<String> AddDonHang(@Query("iduser") String iduser, @Query("idproduct") String idproduct, @Query("soluong") int soluong, @Query("tongtien") int tongtien);
}
