package com.example.brubankchallenge.domain.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class TopRatedMovies(
    @SerializedName("results")
    val movies:
    ArrayList<Movie>
)


