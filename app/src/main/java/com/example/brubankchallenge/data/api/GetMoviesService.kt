package com.example.brubankchallenge.data.api

import com.example.brubankchallenge.domain.model.TopRatedMovies
import retrofit2.Response
import retrofit2.http.GET

interface GetMoviesService {
    @GET("3/movie/top_rated")
    suspend fun getMovieGenres(): Response<TopRatedMovies>
}
