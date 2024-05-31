package com.example.brubankchallenge.domain.repository

import com.example.brubankchallenge.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun addMovie(movie: Movie)
    fun getSubscriptionMovies(): Flow<List<Movie>>

    suspend fun removeMovie(movie: Movie)
}

