package com.openclassrooms.entrevoisins.ui.neighbour_list;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.events.DeleteNeighbourEvent;
import com.openclassrooms.entrevoisins.ui.Detail.DetailActivity;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.ItemClickSupport;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment extends Fragment {

    private NeighbourApiService mApiService;

    private List<Neighbour> favoritesNeighbour ;

    private FavoritesRecyclerAdapter mFavoritesRecyclerAdapter ;

    private static final String TAG = "FavoritesFragment";

   @BindView(R.id.Favorites_RecyclerView)
   RecyclerView mRecyclerView;



    public static FavoritesFragment newInstance () {
        // Required empty public constructor
        return  (new FavoritesFragment());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       mApiService = DI.getNeighbourApiService();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);
        Context context = view.getContext();
        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        initList();
        configureOnClickRecyclerView();
        return view;
    }


    /**
     * Init the List of neighbours
     */
    private void initList() {

        favoritesNeighbour = mApiService.getFavoritesNeighbours();
        mFavoritesRecyclerAdapter = new FavoritesRecyclerAdapter(favoritesNeighbour);
       mRecyclerView.setAdapter(mFavoritesRecyclerAdapter);
    }



    //  Configure item click on RecyclerView
    private void configureOnClickRecyclerView(){
       
        ItemClickSupport.addTo(mRecyclerView, R.layout.fragment_neighbour)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        //  - Get user from adapter
                        Log.d(TAG, "onItemClicked: ");
                        Neighbour neighbour =  mFavoritesRecyclerAdapter.getNeighbour(position);
                        Log.d(TAG, "onItemClicked: Neighbour is "+ neighbour.getName());
                        Toast.makeText(getContext(), "Loading..." + neighbour.getName(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent (getActivity(), DetailActivity.class) ;
                        intent.putExtra("KEYNEIGHBOUR",neighbour) ;
                        startActivity(intent);
                    }
                });
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    /**
     * Fired if the user clicks on a delete button
     * @param event
     */
    @Subscribe
    public void onDeleteNeighbour(DeleteNeighbourEvent event) {
        mApiService.deleteFavoriteNeighbour(event.neighbour);
        initList();
    }



}
