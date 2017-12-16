package com.example.android.ex7;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by eyankiv on 12-Dec-17.
 */

public class CollectionFragement extends Fragment {


    public static final String ARGS_TEXT = "args_text";

    public static CollectionFragement newInstance(String someText) {
        CollectionFragement collectionFragement = new CollectionFragement();
        Bundle bundle = new Bundle();
        bundle.putString(ARGS_TEXT, someText);
        collectionFragement.setArguments(bundle);
        return collectionFragement;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //setup views
        View view = inflater.inflate(R.layout.fragement_collection, container, false);
        View layout = view.findViewById(R.id.fragment_collection_layout);

        //content
        ImageView imageView =  view.findViewById(R.id.fragment_collection_Pic);
        TextView collectionTitle = view.findViewById(R.id.fragment_collection_title);
        String someText = getArguments().getString(ARGS_TEXT);
        //collectionTitle.setText(someText);
        Resources res = getResources();
        collectionTitle.setText("Collection: " +someText);

        return view;


    }
}
