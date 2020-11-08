package com.example.titshop.roomdb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.titshop.model.CartItem;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;
@Dao
public interface ProductLikeDAO {
    @Insert(onConflict = REPLACE)
    public void insert(ProductLike... productLikes);
    @Update
    public void update(ProductLike... productLikes);
    @Delete
    public void delete(ProductLike... productLikes);
    @Query("select * from ProductLike")
    public List<ProductLike> getAllCart();
    @Query("delete from ProductLike")
    public void deleteAllProductLike();
    @Query("select * from ProductLike where id = :ID")
    public ProductLike getProductLikeById(String ID);
}
