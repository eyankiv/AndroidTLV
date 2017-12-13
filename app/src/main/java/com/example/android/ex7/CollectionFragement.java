package com.example.android.ex7;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by eyankiv on 12-Dec-17.
 */

public class CollectionFragement extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //setup views
        View view = inflater.inflate(R.layout.fragement_collection, container, false);
        View layout = view.findViewById(R.id.fragment_collection_layout);
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragement_collection, container, false);


       // TextView textView =  view.findViewById(R.id.fragment_collection_Pic);
        //content
        layout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorAccent));

        //insert image here
        return rootView;


    }
}
