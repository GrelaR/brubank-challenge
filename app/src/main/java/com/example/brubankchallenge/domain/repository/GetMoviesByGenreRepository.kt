package com.example.brubankchallenge.domain.repository

import com.example.brubankchallenge.domain.model.TopRatedMovies

interface GetMoviesByGenreRepository {
    suspend fun getMoviesByGenre(): TopRatedMovies

}
