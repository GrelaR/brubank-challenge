package com.example.brubankchallenge.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subscription_movies")
data class MovieEntity(
    val genresIds: List<Int>,
    @PrimaryKey val id: Int,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val title: String
)
