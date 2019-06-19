package com.suparsana.incinema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String title,description,photo,rating;


        title = getIntent().getStringExtra("Title");
        description = getIntent().getStringExtra("Description");
        photo = getIntent().getStringExtra("Photo");
        rating = getIntent().getStringExtra("Rating");

        TextView tvTitle = findViewById(R.id.tvTitleDetail);
        TextView tvRating = findViewById(R.id.tvRatingDetail);
        TextView tvDesc = findViewById(R.id.tvDescriptionDetail);
        ImageView imgMovie = findViewById(R.id.imgDetailMovie);

        tvTitle.setText(title);
        tvRating.setText(rating);
        tvDesc.setText(description);

        Glide.with(this)
                .load(photo)
                .into(imgMovie);

        getSupportActionBar().setTitle(title);
    }
}
