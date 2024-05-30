package com.example.brubankchallenge.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val posterPath: String,
    val genresIds: List<Int>,
    val overview: String,
    val releaseDate: String
)
