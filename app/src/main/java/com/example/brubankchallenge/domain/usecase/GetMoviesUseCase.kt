package com.example.brubankchallenge.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.brubankchallenge.domain.model.Movie
import com.example.brubankchallenge.domain.repository.GetMoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val getMoviesRepository: GetMoviesRepository
) {
    operator fun invoke(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { getMoviesRepository.getTopRatedMovies() }
        ).flow
    }
}
