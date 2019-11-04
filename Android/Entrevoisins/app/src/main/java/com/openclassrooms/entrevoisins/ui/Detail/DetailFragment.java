package com.openclassrooms.entrevoisins.ui.Detail;


import android.content.Intent;

import android.graphics.PorterDuff;

import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;





import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
    public class DetailFragment extends Fragment {
    @BindView(R.id.floating_Button) FloatingActionButton FL ;
    @BindView(R.id.ac_return) ImageView back;
    @BindView(R.id.title_TextView) TextView title1 ;
    @BindView(R.id.card_title) TextView title2 ;
    @BindView(R.id.card1_textview3) TextView title3 ;
    @BindView(R.id.ac_avatar) ImageView avatar ;
    private static final String TAG = "DetailFragment";
    private NeighbourApiService mApiService;




    public DetailFragment newInstance() {
        // Required empty public constructor
        return (new DetailFragment()) ;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        // Set onClickListener to buttons
        ButterKnife.bind(this,v);
        ConfigureScreen();
        ConfigureFloatingActionButton ();
        ConfigureBackButton () ;
        ConfigureFloatingActionButtonState();
        return v ;
    }

    public void ConfigureFloatingActionButton () {

        FL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getActivity().getIntent();
                Neighbour neighbour = intent.getParcelableExtra("KEYNEIGHBOUR");

                if (mApiService.getFavNeighbours().contains(neighbour)) {
                    Toast.makeText(getActivity(), "Removed to favorites : " + neighbour.getName(), Toast.LENGTH_SHORT).show();
                    FL.setImageResource(R.drawable.ic_star_border_white_24dp);
                    FL.getDrawable().setColorFilter(getResources().getColor(R.color.IconFavoriteOff), PorterDuff.Mode.SRC_IN);
                    Log.d(TAG, "FloatingButtonClick: Default Settings");
                    mApiService.deleteFavNeighbour(neighbour);
                    Log.d(TAG, "FloatingButtonClick: Removed to favorites");
                }else {
                    Toast.makeText(getActivity(), "Added to favorites : " + neighbour.getName(), Toast.LENGTH_SHORT).show();
                    FL.setImageResource(R.drawable.ic_star_white_24dp);
                    FL.getDrawable().setColorFilter(getResources().getColor(R.color.IconFavoriteOn), PorterDuff.Mode.SRC_IN);
                    Log.d(TAG, "FloatingButtonClick: ImageRes and content changed");
                    mApiService.addFavNeighbour(neighbour);
                    Log.d(TAG, "FloatingButtonClick: Added to favorites");
                }
            }
        });
    }

    public void ConfigureBackButton () {

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Log.d(TAG, "ConfigureBackButton : Click on Back button");
                    Toast.makeText(getActivity(), "Chargement...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent (getActivity() , ListNeighbourActivity.class) ;
                    startActivity(intent);
                    Log.d(TAG, "BackButtonClick: Back to ListNeighbourActivity");
            }
        });
    }

    public void ConfigureScreen() {
        Log.d(TAG, "ConfigureScreen: Off");
        Intent intent= getActivity().getIntent();
        Neighbour neighbour = intent.getParcelableExtra("KEYNEIGHBOUR");
        Glide.with(getContext()).load(neighbour.getAvatarUrl()).into(avatar);
        title1.setText( ""+ neighbour.getName());
        title2.setText( ""+ neighbour.getName());
        title3.setText("www.facebook.fr/" + neighbour.getName());
        Log.d(TAG, "ConfigureScreen: On");
    }

    public void ConfigureFloatingActionButtonState() {
        // key = KEYNEIGHBOUR
        Intent intent= getActivity().getIntent();
        Neighbour neighbour = intent.getParcelableExtra("KEYNEIGHBOUR");
        Log.d(TAG, "ConfigureFloatingActionButtonState: getIntent is not Empty");
        mApiService = DI.getNeighbourApiService();
        if(neighbour != null) {
            Log.d(TAG, "onCreate: if(neighbouer !null)");
            if (mApiService.getFavNeighbours().contains(neighbour)){
                Log.d(TAG, "onCreate: Favorites list contains this neighbour ");
                FL.setImageResource(R.drawable.ic_star_white_24dp);
                FL.getDrawable().setColorFilter(getResources().getColor(R.color.IconFavoriteOn), PorterDuff.Mode.SRC_IN);
                Log.d(TAG, "onCreate: Floating button has changed color");
            }
        }
    }
}
