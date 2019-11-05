package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private List<Neighbour> favoritesNeighbour = DummyNeighbourGenerator.generateFavoritesNeighbours();

    /**
     * {@inheritDoc}
     * Get neighbour list
     * Get favorites list
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    @Override
    public List<Neighbour> getFavoritesNeighbours() {
        return favoritesNeighbour ;
    }

    /**
     * {@inheritDoc}
     * Delete neighbour
     * Delete favorite neighbour
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    @Override
    public void deleteFavoriteNeighbour(Neighbour neighbour) {
        favoritesNeighbour.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     * add neighbour to favorites list
     */
    @Override
    public void addFavoriteNeighbour(Neighbour neighbour) {
        favoritesNeighbour.add(neighbour);
    }



}
