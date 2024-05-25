package com.example.brubankchallenge.data.api

import com.example.brubankchallenge.domain.model.MovieGenresList
import retrofit2.Response
import retrofit2.http.GET

interface GetMoviesService {
    @GET("/3/genre/movie/list")
    suspend fun getMovieGenres(): Response<MovieGenresList>
}
