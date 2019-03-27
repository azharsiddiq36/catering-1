package com.example.anonymous.catering.network;

import com.example.anonymous.catering.LoggingInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    //192.168.100.95
    //192.168.100.15
    public static final String URL = "http://192.168.100.95/android_maps/";
    public static Retrofit RETROFIT = null;
    public static Retrofit retrofit = null;
    public static Retrofit retrofit2 = null;

    public static Retrofit getClient(){

        if (RETROFIT==null){
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new LoggingInterceptor())
                    .build();

            RETROFIT = new Retrofit.Builder()
                    .baseUrl(URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return RETROFIT;
    }

    public static Retrofit getApiProv(String BASE_URL){
        if(retrofit2==null){
            retrofit2 = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit2;
    }


}
