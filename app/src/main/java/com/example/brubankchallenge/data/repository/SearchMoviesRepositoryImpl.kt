package com.example.brubankchallenge.data.repository

import androidx.paging.PagingSource
import com.example.brubankchallenge.data.datasource.GetMoviesDataSource
import com.example.brubankchallenge.data.datasource.MoviePagingSource
import com.example.brubankchallenge.data.datasource.SearchMoviesDataSource
import com.example.brubankchallenge.domain.model.Movie
import com.example.brubankchallenge.domain.repository.SearchMoviesRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class SearchMoviesRepositoryImpl @Inject constructor(
    private val getMoviesDataSource: GetMoviesDataSource,
    private val searchMoviesDataSource: SearchMoviesDataSource
) : SearchMoviesRepository {
    override fun searchMovies(query: String): PagingSource<Int, Movie> {
        return MoviePagingSource(getMoviesDataSource, searchMoviesDataSource, query)
    }


}
