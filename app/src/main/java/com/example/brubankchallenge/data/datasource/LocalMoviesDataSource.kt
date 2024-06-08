package com.example.brubankchallenge.data.datasource

import com.example.brubankchallenge.data.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

interface LocalMoviesDataSource {
    suspend fun addMovie(movie: MovieEntity)
    fun getSubscriptionMovies(): Flow<List<MovieEntity>>
    suspend fun removeMovie(movie: MovieEntity)
}
