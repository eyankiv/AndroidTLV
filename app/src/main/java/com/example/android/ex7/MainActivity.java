package com.example.android.ex7;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String MAIN_FRAGMENT = "Main Fragment";

    private ViewPager mPager;
    private CollectionsPagerAdapter mPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 13-Dec-17 populate fragements list

        List<CollectionFragement> fragements = new ArrayList<>();
        CollectionFragement collectionHello = CollectionFragement.newInstance("hello");
        CollectionFragement collectionNext = CollectionFragement.newInstance("goodbye");
        CollectionFragement collectionLast = CollectionFragement.newInstance("last but not least");
        fragements.add(collectionHello);
        fragements.add(collectionNext);
        fragements.add(collectionLast);


        mPager = findViewById(R.id.activity_main_fragment_pager);
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
}
