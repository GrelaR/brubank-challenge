package com.example.brubankchallenge.data.datasource

import com.example.brubankchallenge.data.dto.MovieResponseDto
import retrofit2.Response

interface SearchMoviesDataSource {
    suspend fun searchMovies(query: String, page: Int): Response<MovieResponseDto>
}
