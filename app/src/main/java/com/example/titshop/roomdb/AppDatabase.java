package com.example.titshop.roomdb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.titshop.model.CartItem;

@Database(entities = {CartItem.class, ProductView.class,ProductLike.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CartDAO getCartDao();
    public abstract ProductLikeDAO getProductLikeDao();
    public abstract ProductViewDAO getProductViewDao();
}
