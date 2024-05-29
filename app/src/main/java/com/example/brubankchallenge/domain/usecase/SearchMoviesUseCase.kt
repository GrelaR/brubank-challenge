package com.example.brubankchallenge.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.brubankchallenge.data.datasource.SearchMoviesDataSource
import com.example.brubankchallenge.domain.model.Movie
import com.example.brubankchallenge.domain.repository.SearchMoviesRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class SearchMoviesUseCase @Inject constructor(
    private val searchMoviesRepository: SearchMoviesRepository
) {
    operator fun invoke(query: String): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { searchMoviesRepository.searchMovies(query) }
        ).flow
    }
}
