package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours and favorites neighbour
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    List<Neighbour> getFavoritesNeighbours();

    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    void deleteFavoriteNeighbour(Neighbour neighbour);

    /**
     * Add neighbour to the favorites list
     * @param neighbour
     */
    void addFavoriteNeighbour(Neighbour neighbour);

}
