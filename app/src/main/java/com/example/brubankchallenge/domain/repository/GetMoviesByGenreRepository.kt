package com.example.brubankchallenge.domain.repository

import com.example.brubankchallenge.domain.model.MovieGenresList

interface GetMoviesByGenreRepository {
    suspend fun getMoviesByGenre(): MovieGenresList

}
