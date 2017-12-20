package com.example.android.ex7;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.ex7.Entities.Collection;
import com.squareup.picasso.Picasso;

/**
 * Created by eyankiv on 12-Dec-17.
 */

public class CollectionFragement extends Fragment implements View.OnClickListener {


    public static final String ARGS_COLLECTION_ID = "args_collection_id";

    private View previewLayout;
    private View detailsLayout;

    private Collection collection;

    //preview layout views
    private TextView collectionTitle;
    private ImageView imageView;
    private TextView collectionDescription;

    //details layout views
    private Button btnCloseDetails;
    private RecyclerView recyclerView;
    private Button btnViewWebCollections;



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
        Integer id = getArguments().getInt(ARGS_COLLECTION_ID);

        //preview layout
        collectionTitle = view.findViewById(R.id.fragment_collection_title);
        imageView =  view.findViewById(R.id.fragment_collection_Pic);
        collectionDescription = view.findViewById(R.id.fragment_collection_description);
        collectionTitle.setText("Collection # " +id.toString());
        //details layout
        btnCloseDetails = view.findViewById(R.id.Btn_close_details);
        recyclerView = view.findViewById(R.id.fragment_recyclerView_collection_Pic);
        btnViewWebCollections = view.findViewById(R.id.Btn_open_collection_web_link);



        //collectionTitle.setText(someText);

        //picasso here
        String imageUrl = collection.getPreviewPhotos().get(0).getUrls().getSmall();
        Picasso.with(getContext()).load(imageUrl).into(imageView);
        collectionDescription.setText(CollectionsRepository.getInstance().getCollection(id).getDescription());


        return view;

    }

    private void showDetailsLayout(){

    }

    private void showPreviewLayout(){

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fragment_collection_preview_layout:
                showDetailsLayout();
                break;
            case R.id.Btn_close_details:
                showPreviewLayout();
                break;
            case R.id.Btn_open_collection_web_link:
                //listener to show collection
                break;

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //null listener
    }

    public interface CollectionFragmentListener{
        void onCollectedSelected(Collection collection);
    }
}
