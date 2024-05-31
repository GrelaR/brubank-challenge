package com.example.brubankchallenge.data.repository

import com.example.brubankchallenge.data.datasource.LocalMoviesDataSource
import com.example.brubankchallenge.data.mapper.toDomain
import com.example.brubankchallenge.data.mapper.toEntity
import com.example.brubankchallenge.domain.model.Movie
import com.example.brubankchallenge.domain.repository.MovieRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepositoryImpl @Inject constructor(
    private val localMoviesDataSource: LocalMoviesDataSource
) : MovieRepository {
    override suspend fun addMovie(movie: Movie) {
        localMoviesDataSource.addMovie(movie.toEntity())
    }

    override fun getSubscriptionMovies(): Flow<List<Movie>> {
        return localMoviesDataSource.getSubscriptionMovies().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun removeMovie(movie: Movie) {
        localMoviesDataSource.removeMovie(movie.toEntity())
    }
}
