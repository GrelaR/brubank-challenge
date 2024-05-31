package com.example.brubankchallenge.domain.repository

import androidx.paging.PagingSource
import com.example.brubankchallenge.domain.model.Movie

interface GetMoviesRepository {
    fun getTopRatedMovies(): PagingSource<Int, Movie>
}
