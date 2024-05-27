package com.example.brubankchallenge.domain.repository

import com.example.brubankchallenge.domain.model.MovieGenresResponse

interface GetGenresRepository {
    suspend fun getMovieGenres(): MovieGenresResponse

}
