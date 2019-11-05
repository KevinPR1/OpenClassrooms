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
    @BindView(R.id.card1_textview2) TextView phone ;
    @BindView(R.id.description_textview) TextView aboutme ;
    @BindView(R.id.card1_textview1) TextView lieu;
    private static final String TAG = "DetailFragment";
    private NeighbourApiService mApiService;
    Intent mIntent ;
    String Name;
    String Place;
    String cellphone;
    String Facebook;
    String AboutNeighbour;


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
        mIntent = getActivity().getIntent();
        Neighbour neighbour = mIntent.getParcelableExtra("KEYNEIGHBOUR");
        Name = neighbour.getName();
        Place = neighbour.getPlace();
        cellphone = neighbour.getCellphone();
        Facebook = neighbour.getFacebook();
        AboutNeighbour= neighbour.getAbout();
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

                Neighbour neighbour = mIntent.getParcelableExtra("KEYNEIGHBOUR");
                if (mApiService.getFavoritesNeighbours().contains(neighbour)) {
                    Toast.makeText(getActivity(), "Removed to favorites : " + neighbour.getName(), Toast.LENGTH_SHORT).show();
                    FL.setImageResource(R.drawable.ic_star_border_white_24dp);
                    FL.getDrawable().setColorFilter(getResources().getColor(R.color.IconFavoriteOff), PorterDuff.Mode.SRC_IN);
                    Log.d(TAG, "FloatingButtonClick: Default Settings");
                    mApiService.deleteFavoriteNeighbour(neighbour);
                    Log.d(TAG, "FloatingButtonClick: Removed to favorites");
                }else {
                    Toast.makeText(getActivity(), "Added to favorites : " + neighbour.getName(), Toast.LENGTH_SHORT).show();
                    FL.setImageResource(R.drawable.ic_star_white_24dp);
                    FL.getDrawable().setColorFilter(getResources().getColor(R.color.IconFavoriteOn), PorterDuff.Mode.SRC_IN);
                    Log.d(TAG, "FloatingButtonClick: ImageRes and content changed");
                    mApiService.addFavoriteNeighbour(neighbour);
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
        Neighbour neighbour = mIntent.getParcelableExtra("KEYNEIGHBOUR");
        Glide.with(getContext()).load(neighbour.getAvatarUrl()).into(avatar);
        title1.setText(Name);
        title2.setText(Name);
        title3.setText("www.facebook.fr/" + Facebook);
        phone.setText(cellphone); ;
        aboutme.setText(AboutNeighbour);
        lieu.setText(Place);
        Log.d(TAG, "ConfigureScreen: On");
    }

    public void ConfigureFloatingActionButtonState() {
        // key = KEYNEIGHBOUR
        Neighbour neighbour = mIntent.getParcelableExtra("KEYNEIGHBOUR");
        Log.d(TAG, "ConfigureFloatingActionButtonState: getIntent is not Empty");
        mApiService = DI.getNeighbourApiService();
        if(neighbour != null) {
            Log.d(TAG, "onCreate: if(neighbouer !null)");
            if (mApiService.getFavoritesNeighbours().contains(neighbour)){
                Log.d(TAG, "onCreate: Favorites list contains this neighbour ");
                FL.setImageResource(R.drawable.ic_star_white_24dp);
                FL.getDrawable().setColorFilter(getResources().getColor(R.color.IconFavoriteOn), PorterDuff.Mode.SRC_IN);
                Log.d(TAG, "onCreate: Floating button has changed color");
            }
        }
    }
}
