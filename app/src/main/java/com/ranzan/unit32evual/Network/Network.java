package com.ranzan.unit32evual.Network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    private static final String BASE_URL = "https://itunes.apple.com/";

    public static retrofit2.Retrofit getRetrofitInstance() {
        return new Retrofit
                .Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().
                        addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                        .build())
                .build();

    }
}
