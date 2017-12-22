package com.example.android.ex7;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.android.ex7.Api.UnsplashApiHelper;
import com.example.android.ex7.Entities.Collection;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements CollectionFragement.CollectionFragmentListener{

    public static final String MAIN_FRAGMENT = "Main Fragment";
    private static final String TAG = "response_body";

    private ViewPager mPager;
    private CollectionsPagerAdapter mPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 13-Dec-17 populate fragements list

//        List<CollectionFragement> fragements = new ArrayList<>();
//        CollectionFragement collectionHello = CollectionFragement.newInstance("hello");
//        CollectionFragement collectionNext = CollectionFragement.newInstance("goodbye");
//        CollectionFragement collectionLast = CollectionFragement.newInstance("last but not least");
//        fragements.add(collectionHello);
//        fragements.add(collectionNext);
//        fragements.add(collectionLast);



        //api call
        UnsplashApiHelper unsplashApiHelper = new UnsplashApiHelper();
        unsplashApiHelper.service().getFeaturedCollections().enqueue(new Callback<List<Collection>>() {
            @Override
            public void onResponse(Call<List<Collection>> call, Response<List<Collection>> response) {
                List<Collection> collections = response.body();
                if (collections != null) {
                    for (Collection collection:collections) {
                        CollectionsRepository.getInstance().saveCollection(collection);
                    }
                    initViewPager();

                }else {
                    showErrorMessage(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<Collection>> call, Throwable t) {
                showErrorMessage(t.getMessage());
            }
        });




    }

    private void initViewPager() {
        List<Collection> collections =  CollectionsRepository.getInstance().getCollections();
        mPager = findViewById(R.id.activity_main_fragment_pager);
        List<CollectionFragement> fragements = new ArrayList<>();
        for (Collection collection:collections) {
            fragements.add(CollectionFragement.newInstance(collection.getId()));
        }
        mPagerAdapter = new CollectionsPagerAdapter(getSupportFragmentManager(), fragements);//TODO above
        mPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        }else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    public void showErrorMessage(String errorMessage){
        Toast.makeText(this, "Something went wrong: "+errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCollectedSelected(Collection collection) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(collection.getLinks().getHtml()));
        startActivity(browserIntent);
    }
}
