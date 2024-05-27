package com.example.brubankchallenge.data.datasource

import com.example.brubankchallenge.domain.model.MovieResponse
import retrofit2.Response

interface GetMoviesDataSource {
    suspend fun getMovies(currentPage: Int): Response<MovieResponse>
}
