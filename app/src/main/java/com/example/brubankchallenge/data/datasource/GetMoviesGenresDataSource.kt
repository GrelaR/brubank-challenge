package com.example.brubankchallenge.data.datasource

import com.example.brubankchallenge.domain.model.TopRatedMovies
import retrofit2.Response

interface GetMoviesGenresDataSource {
    suspend fun getMoviesGenresData(): Response<TopRatedMovies>
}
