package com.example.brubankchallenge.data.repository

import androidx.paging.PagingSource
import com.example.brubankchallenge.data.datasource.GetMoviesDataSource
import com.example.brubankchallenge.data.datasource.MoviePagingSource
import com.example.brubankchallenge.domain.model.Movie
import com.example.brubankchallenge.domain.repository.GetMoviesRepository
import javax.inject.Inject

class GetMoviesRepositoryImpl @Inject constructor(
    private val getMoviesDataSource: GetMoviesDataSource
) : GetMoviesRepository {

    override fun getTopRatedMovies(): PagingSource<Int, Movie> {
        return MoviePagingSource(getMoviesDataSource)
    }
}
