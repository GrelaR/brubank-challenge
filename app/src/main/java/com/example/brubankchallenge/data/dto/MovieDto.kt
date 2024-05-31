package com.example.brubankchallenge.data.dto

import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("genre_ids")
    val genresIds: List<Int>?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("title")
    val title: String?,
)
