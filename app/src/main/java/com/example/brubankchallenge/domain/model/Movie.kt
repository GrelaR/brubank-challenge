package com.example.brubankchallenge.domain.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("poster_path")
    val posterPath: String?
)
