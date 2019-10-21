package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


public class ListNeighbourPagerAdapter extends FragmentPagerAdapter {




    public ListNeighbourPagerAdapter(FragmentManager fm ) {
        super(fm);
    }

    /**
     * getItem is called to instantiate the fragment for the given page.
     * @param position
     * @return null
     */
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: //Page number 1
                return NeighbourFragment.newInstance();
            case 1: //Page number 2
                return FavoritesFragment.newInstance() ;
            default:
                return null;

        }

    }



    /**
     * get the number of pages
     * @return
     */
    @Override
    public int getCount() {
        return 2;
    }
}