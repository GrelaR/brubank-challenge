package com.example.brubankchallenge.data.datasource

import com.example.brubankchallenge.data.dto.GenresResponseDto
import retrofit2.Response

interface GetGenresDataSource {
    suspend fun getMoviesGenres(): Response<GenresResponseDto>
}
