package com.example.brubankchallenge.data.datasource

import com.example.brubankchallenge.domain.model.MovieGenresResponse
import retrofit2.Response

interface GetGenresDataSource {
    suspend fun getMoviesGenres(): Response<MovieGenresResponse>
}
