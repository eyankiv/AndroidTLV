package com.example.android.ex7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CollectionFragement collectionFragement = new CollectionFragement();
        getSupportFragmentManager().beginTransaction().add(R.id.activity_main_fragment_pager
                , collectionFragement, "Main Fragment").commit();



    }
}
