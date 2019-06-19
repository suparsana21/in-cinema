package com.suparsana.incinema;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.suparsana.incinema.adapter.MovieListAdapter;
import com.suparsana.incinema.data.MovieData;
import com.suparsana.incinema.model.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMovie;

    private ArrayList<Movie> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvMovie = findViewById(R.id.rv_movie_list);
        rvMovie.setHasFixedSize(true);

        movieList.addAll(MovieData.getListData());

        showRecyclerList();


    }

    private void showRecyclerList(){
        rvMovie.setLayoutManager(new LinearLayoutManager(this));
        MovieListAdapter movieListAdapter = new MovieListAdapter(this);
        movieListAdapter.setMovieList(movieList);
        rvMovie.setAdapter(movieListAdapter);

    }
}
