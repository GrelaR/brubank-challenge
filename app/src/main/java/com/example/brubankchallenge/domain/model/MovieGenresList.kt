package com.example.brubankchallenge.domain.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class MovieGenresList(
    @SerializedName("genres")
    val genres:
    ArrayList<MovieGenre>
)


