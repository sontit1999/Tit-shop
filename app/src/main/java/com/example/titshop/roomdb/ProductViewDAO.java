package com.example.titshop.roomdb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;
@Dao
public interface ProductViewDAO {
    @Insert(onConflict = REPLACE)
    public void insert(ProductView... productViews);
    @Update
    public void update(ProductView... productViews);
    @Delete
    public void delete(ProductView... productViews);
    @Query("select * from ProductView")
    public List<ProductView> getAllProduct();
    @Query("delete from ProductView")
    public void deleteAllProductView();
    @Query("select * from ProductView where id = :ID")
    public ProductView getProductViewById(String ID);
}
