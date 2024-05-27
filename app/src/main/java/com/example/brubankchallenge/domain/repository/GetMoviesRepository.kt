package com.example.brubankchallenge.domain.repository

import com.example.brubankchallenge.domain.model.MovieResponse

interface GetMoviesRepository {
    suspend fun getTopRatedMovies(currentPage: Int): MovieResponse

}
