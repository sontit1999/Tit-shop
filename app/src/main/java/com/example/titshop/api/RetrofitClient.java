package com.example.titshop.api;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    //public static final String  BASE_URL = "http://172.20.10.2:8012/shoppe/";
     public static final String  BASE_URL = "http://192.168.14.107:8012/shoppe/";
   // public static final String BASE_URL = "http://192.168.0.101:8012/shoppe/";
    private static Retrofit sRetrofit = null;
    public static Retrofit getInstance(Context context) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return sRetrofit;
    }
}
