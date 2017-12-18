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

import com.example.android.ex7.Entities.Collection;
import com.squareup.picasso.Picasso;

/**
 * Created by eyankiv on 12-Dec-17.
 */

public class CollectionFragement extends Fragment {


    public static final String ARGS_COLLECTION_ID = "args_collection_id";

    private Collection collection;

    public static CollectionFragement newInstance(int collectionId) {
        CollectionFragement collectionFragement = new CollectionFragement();
        Bundle bundle = new Bundle();
        bundle.putInt(ARGS_COLLECTION_ID, collectionId);
        collectionFragement.setArguments(bundle);
        return collectionFragement;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int collectionId = getArguments().getInt(ARGS_COLLECTION_ID);
        collection = CollectionsRepository.getInstance().getCollection(collectionId);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //setup views
        View view = inflater.inflate(R.layout.fragement_collection, container, false);
        View layout = view.findViewById(R.id.fragment_collection_layout);

        //content

        TextView collectionTitle = view.findViewById(R.id.fragment_collection_title);
        ImageView imageView =  view.findViewById(R.id.fragment_collection_Pic);
        TextView collectionDescription = view.findViewById(R.id.fragment_collection_description);
        Integer id = getArguments().getInt(ARGS_COLLECTION_ID);
        //collectionTitle.setText(someText);
        collectionTitle.setText("Collection # " +id.toString());
        //picasso here
        String imageUrl = collection.getPreviewPhotos().get(0).getUrls().getSmall();
        Picasso.with(getContext()).load(imageUrl).into(imageView);
        collectionDescription.setText(CollectionsRepository.getInstance().getCollection(id).getDescription());


        return view;


    }
}
