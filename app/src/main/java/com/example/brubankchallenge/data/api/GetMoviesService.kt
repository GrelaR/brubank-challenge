package com.example.brubankchallenge.data.api

import com.example.brubankchallenge.data.dto.GenresResponseDto
import com.example.brubankchallenge.data.dto.MovieResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GetMoviesService {
    @GET("movie/top_rated")
    suspend fun getMovieTopRated(
        @Query("page") page: Int
    ): Response<MovieResponseDto>

    @GET("genre/movie/list")
    suspend fun getMovieGenres(
    ): Response<GenresResponseDto>

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("page") page: Int
    ): Response<MovieResponseDto>
}
