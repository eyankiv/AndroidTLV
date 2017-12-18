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
    String Application_ID = "9a550290e242b403c1ba7aba1965db32b93d5877054a0a5add86b0fdf2e8beb6";

    @GET ("/collections/curated/?client_id=" + Application_ID)
    Call<List<Collection>> getFeaturedCollections();
}
