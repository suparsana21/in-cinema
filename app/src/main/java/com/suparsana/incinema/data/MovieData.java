package com.suparsana.incinema.data;

import com.suparsana.incinema.model.Movie;

import java.util.ArrayList;

public class MovieData {
    public static String[][] data = new String[][]{
            {"Avengers : End Game", "8.7 / 10", "http://cdn.collider.com/wp-content/uploads/2019/04/avengers-endgame-poster-3d.png","Melanjutkan Avengers Infinity War, dimana kejadian setelah Thanos berhasil mendapatkan semua infinity stones dan memusnahkan 50% semua mahluk hidup di alam semesta. Akankah para Avengers berhasil mengalahkan Thanos?"}
    };

    public static ArrayList<Movie> getListData(){
        Movie movie = null;
        ArrayList<Movie> list = new ArrayList<>();
        for (String[] aData : data) {
            movie = new Movie();
            movie.setTitle(aData[0]);
            movie.setRating(aData[1]);
            movie.setPhoto(aData[2]);
            movie.setDescription(aData[3]);

            list.add(movie);
        }

        return list;
    }
}
