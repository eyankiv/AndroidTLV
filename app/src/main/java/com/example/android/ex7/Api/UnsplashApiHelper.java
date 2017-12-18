package com.example.android.ex7.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by eyankiv on 16-Dec-17.
 */

public class UnsplashApiHelper {

    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.unsplash.com/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    public UnsplashService service(){
        return retrofit.create(UnsplashService.class);
    }
}
