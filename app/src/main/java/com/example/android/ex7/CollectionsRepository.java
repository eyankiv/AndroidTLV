package com.example.android.ex7;

import com.example.android.ex7.Entities.Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by eyankiv on 16-Dec-17.
 */

public class CollectionsRepository  {
    private static final CollectionsRepository instance = new CollectionsRepository();

    private HashMap<Integer,Collection> collectionHashMap;

    public static CollectionsRepository getInstance(){
        return instance;
    }

    private CollectionsRepository(){
        this.collectionHashMap = new HashMap<>();
    }

    public void saveCollection(Collection collection) {
        collectionHashMap.put(collection.getId(), collection);
    }

    public Collection getCollection(int id) {
        return collectionHashMap.get(id);
    }

    public List<Collection> getCollections(){
        return new ArrayList<>(collectionHashMap.values());
    }






}
