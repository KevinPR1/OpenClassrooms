package com.openclassrooms.entrevoisins.ui.neighbour_list;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.events.DeleteNeighbourEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by Kevin  - Openclassrooms on 30/10/2019
 */
public class FavoritesRecyclerAdapter extends RecyclerView.Adapter<MyNeighbourRecyclerViewAdapter.ViewHolder> {


    private List<Neighbour> favoritesNeighbour ;

    public FavoritesRecyclerAdapter(List<Neighbour> favoritesNeighbour) {
        this.favoritesNeighbour = favoritesNeighbour;
    }


    @Override
    public MyNeighbourRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragment_neighbour, viewGroup, false);

        return new MyNeighbourRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MyNeighbourRecyclerViewAdapter.ViewHolder viewHolder, int position) {
        Neighbour neighbour = favoritesNeighbour.get(position);
        viewHolder.mNeighbourName.setText(neighbour.getName());
        Glide.with(viewHolder.mNeighbourAvatar.getContext())
                .load(neighbour.getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(viewHolder.mNeighbourAvatar);

        viewHolder.mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new DeleteNeighbourEvent(neighbour));
            }
        });
    }

    @Override
    public int getItemCount() {
        return favoritesNeighbour.size();
    }


    public Neighbour getNeighbour (int position) {

        return favoritesNeighbour.get(position);
    }



}
