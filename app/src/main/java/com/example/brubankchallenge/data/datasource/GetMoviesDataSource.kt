package com.example.brubankchallenge.data.datasource

import com.example.brubankchallenge.data.dto.MovieResponseDto
import retrofit2.Response

interface GetMoviesDataSource {
    suspend fun getMovies(page: Int): Response<MovieResponseDto>
}
