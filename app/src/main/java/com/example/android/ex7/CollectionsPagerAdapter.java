package com.example.android.ex7;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by eyankiv on 13-Dec-17.
 */

public class CollectionsPagerAdapter extends FragmentStatePagerAdapter{
    private List<CollectionFragement> fragements;

    public CollectionsPagerAdapter(FragmentManager fm,List<CollectionFragement> fragments) {
        super(fm);
        this.fragements = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragements.get(position);
    }

    @Override
    public int getCount() {
        return fragements.size();
    }
}
