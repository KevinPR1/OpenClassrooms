package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyNeighbourGenerator {

    public static List<Neighbour> DUMMY_NEIGHBOURS = Arrays.asList(
            new Neighbour(1, "Caroline", "http://i.pravatar.cc/150?u=a042581f4e29026704d","+33 6 45 21 63 78","Île-de-France11","caroline","about1"),
            new Neighbour(2, "Jack", "http://i.pravatar.cc/150?u=a042581f4e29026704e","+33 6 78 21 82 78","Île-de-Franc12e","jack","about2"),
            new Neighbour(3, "Chloé", "http://i.pravatar.cc/150?u=a042581f4e29026704f","+33 6 90 21 97 05","Île-de-France13","chloé","about3"),
            new Neighbour(4, "Vincent", "http://i.pravatar.cc/150?u=a042581f4e29026704a","+33 7 14 21 63 03","Île-de-France14","vincent","about4"),
            new Neighbour(5, "Elodie", "http://i.pravatar.cc/150?u=a042581f4e29026704b","+33 7 45 66 63 94","Île-de-France15","elodie","about5"),
            new Neighbour(6, "Sylvain", "http://i.pravatar.cc/150?u=a042581f4e29026704c","+33 7 25 03 04 18","Île-de-France16","sylvain","about6"),
            new Neighbour(7, "Laetitia", "http://i.pravatar.cc/150?u=a042581f4e29026703d","+33 6 88 68 90 38","Île-de-France17","laetitia","about7"),
            new Neighbour(8, "Dan", "http://i.pravatar.cc/150?u=a042581f4e29026703b","+33 6 54 12 36 87","Île-de-France18","dan","about8"),
            new Neighbour(9, "Joseph", "http://i.pravatar.cc/150?u=a042581f4e29026704d","+33 7 95 31 83 10","Île-de-France19","joseph","about9"),
            new Neighbour(10, "Emma", "http://i.pravatar.cc/150?u=a042581f4e29026706d","+33 6 96 21 41 78","Île-de-France110","emma","about10"),
            new Neighbour(11, "Patrick", "http://i.pravatar.cc/150?u=a042581f4e29026702d","+33 6 45 67 12 47","Île-de-France111","patrick","about11"),
            new Neighbour(12, "Ludovic", "http://i.pravatar.cc/150?u=a042581f3e39026702d","+33 6 00 21 63 00","Île-de-France112","ludovic","about12")
    );

    static List<Neighbour> generateNeighbours() {
        return new ArrayList<>(DUMMY_NEIGHBOURS);
    }




    public static List<Neighbour> DUMMY_FAVORITES_NEIGHBOURS = Arrays.asList(

    );

     static List<Neighbour> generateFavoritesNeighbours() { return new ArrayList<>(DUMMY_FAVORITES_NEIGHBOURS); }

}
