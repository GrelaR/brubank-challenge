package com.example.brubankchallenge.data.datasource

import com.example.brubankchallenge.domain.model.MovieResponse
import retrofit2.Response

interface SearchMoviesDataSource {
    suspend fun searchMovies(query: String, page: Int): Response<MovieResponse>
}
