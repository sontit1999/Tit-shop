package com.example.titshop.ultis;

import android.content.Context;

import androidx.room.Room;

import com.example.titshop.roomdb.AppDatabase;

public class Constant {
    public static final String typeLike = "like";
    public static final String typeView = "viewd";
    public static final String typeBought = "bought";
    public static final String typeWait = "wait";
    public static AppDatabase database = null ;
    public static void initDatabase(Context context){
        if(database==null){
            database  = Room.databaseBuilder(context, AppDatabase.class, "mydb")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
    }

    public static AppDatabase getDatabase() {
        return database;
    }
}
