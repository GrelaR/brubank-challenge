package com.example.brubankchallenge.domain.model

data class Movie(
    val genresIds: List<Int>,
    val id: Int,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val title: String
)
