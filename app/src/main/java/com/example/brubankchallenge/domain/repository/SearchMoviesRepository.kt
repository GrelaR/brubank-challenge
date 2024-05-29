package com.example.brubankchallenge.domain.repository

import androidx.paging.PagingSource
import com.example.brubankchallenge.domain.model.Movie

interface SearchMoviesRepository {
    fun searchMovies(query: String): PagingSource<Int, Movie>
}
