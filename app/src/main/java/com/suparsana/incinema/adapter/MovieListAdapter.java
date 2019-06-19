package com.suparsana.incinema.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.suparsana.incinema.DetailMovieActivity;
import com.suparsana.incinema.R;
import com.suparsana.incinema.model.Movie;

import java.util.ArrayList;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {


    private Context context;
    private ArrayList<Movie> movieList;


    public MovieListAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_film, viewGroup, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        movieViewHolder.tvTitle.setText(getMovieList().get(i).getTitle());
        movieViewHolder.tvRating.setText("Rating : " + getMovieList().get(i).getRating());

        Glide.with(context)
                .load(getMovieList().get(i).getPhoto())
                .apply(new RequestOptions().override(100, 140))
                .into(movieViewHolder.imgMovie);

        final Movie itmMovie = getMovieList().get(i);

        movieViewHolder.btnMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailMovieActivity.class);

                intent.putExtra("Title",itmMovie.getTitle());
                intent.putExtra("Rating",itmMovie.getRating());
                intent.putExtra("Description",itmMovie.getDescription());
                intent.putExtra("Photo",itmMovie.getPhoto());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getMovieList().size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvRating;
        ImageView imgMovie;
        Button btnMovie;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvMovieName);
            tvRating = itemView.findViewById(R.id.tvMovieRating);
            imgMovie = itemView.findViewById(R.id.imgMovie);
            btnMovie = itemView.findViewById(R.id.btnInfoMovie);


        }
    }
}
