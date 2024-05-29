package com.example.brubankchallenge.data.api

import com.example.brubankchallenge.domain.model.MovieGenresResponse
import com.example.brubankchallenge.domain.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GetMoviesService {
    @GET("movie/top_rated")
    suspend fun getMovieTopRated(
        @Query("page") page: Int
    ): Response<MovieResponse>

    @GET("genre/movie/list")
    suspend fun getMovieGenres(
    ): Response<MovieGenresResponse>
}
