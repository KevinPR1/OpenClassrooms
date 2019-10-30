package com.openclassrooms.entrevoisins.ui.Detail;



import android.content.Intent;

import android.content.SharedPreferences;
import android.graphics.PorterDuff;

import android.support.design.widget.FloatingActionButton;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_list.FavoritesFragment;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourPagerAdapter;
import com.openclassrooms.entrevoisins.ui.neighbour_list.NeighbourFragment;

import java.util.jar.Attributes;

public class DetailActivity extends AppCompatActivity {

    private DetailFragment mDetailFragment ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        configureAndShowMainFragment();

    }



private void configureAndShowMainFragment() {

    //  Get FragmentManager (Support) and Try to find existing instance of fragment in FrameLayout container
    mDetailFragment= (DetailFragment)
            getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail_activity);

        if (mDetailFragment== null){
            mDetailFragment = new DetailFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_detail_activity,mDetailFragment)
                    .commit();
        }


}

//__________________________________________________________________________________________________





}
