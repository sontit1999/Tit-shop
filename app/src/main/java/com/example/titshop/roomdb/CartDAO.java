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
public interface CartDAO {
    @Insert(onConflict = REPLACE)
    public void insert(CartItem... cartItems);
    @Update
    public void update(CartItem... cartItems);
    @Delete
    public void delete(CartItem... cartItems);
    @Query("select * from Cart")
    public List<CartItem> getAllCart();
    @Query("delete from Cart")
    public void deleteAllCart();
    @Query("select * from Cart where id = :IDcart")
    public CartItem getCartById(String IDcart);
}
