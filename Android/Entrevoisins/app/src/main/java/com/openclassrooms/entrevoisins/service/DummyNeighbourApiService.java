package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private List<Neighbour> favoritesNeighbour = DummyNeighbourGenerator.generateFavNeighbours();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    @Override
    public List<Neighbour> getFavNeighbours() {
        return favoritesNeighbour ;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);

    }

    @Override
    public void deleteFavNeighbour(Neighbour neighbour) {
        favoritesNeighbour.remove(neighbour);
    }

    @Override
    public void addFavNeighbour(Neighbour neighbour) {
        favoritesNeighbour.add(neighbour);
    }
}
