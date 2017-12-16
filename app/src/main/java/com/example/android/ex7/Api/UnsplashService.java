package com.example.android.ex7.Api;

import com.example.android.ex7.Entities.Collection;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by eyankiv on 16-Dec-17.
 */

public interface UnsplashService {
    @GET ("/collections/curated/?client_id+")
    Call<List<Collection>> getFeaturedCollections();
}
