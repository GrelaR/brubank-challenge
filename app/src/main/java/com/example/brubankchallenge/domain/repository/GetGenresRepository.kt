package com.example.brubankchallenge.domain.repository

import com.example.brubankchallenge.domain.model.Genre
import kotlinx.coroutines.flow.Flow

interface GetGenresRepository {
    fun getMovieGenres(): Flow<List<Genre>>
}
