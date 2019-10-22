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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        configureImageView();
    }

// _________________________________________________________________________________________________

   private ImageView imageViewOC;


    private void configureImageView(){

        // Serialise ImageView
        imageViewOC =(ImageView) findViewById(R.id.ac_ImageView) ;
        // Set OnClick Listener on it
        imageViewOC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchDetailActivity();
            }
        });
    }
    private void launchDetailActivity(){
        Intent intent = new Intent( DetailActivity.this,ListNeighbourActivity.class) ;
      startActivity(intent);
    }



//__________________________________________________________________________________________________








}
