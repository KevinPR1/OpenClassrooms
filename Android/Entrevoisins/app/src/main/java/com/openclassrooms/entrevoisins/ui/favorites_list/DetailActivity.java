package com.openclassrooms.entrevoisins.ui.favorites_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;

import butterknife.BindView;

public class DetailActivity extends AppCompatActivity {

    private DetailFragment mDetailFragment ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        configureAndShowMainFragment();
    }



private void configureAndShowMainFragment() {

    // A - Get FragmentManager (Support) and Try to find existing instance of fragment in FrameLayout container
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
