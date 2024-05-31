package com.example.brubankchallenge.data.datasource

import com.example.brubankchallenge.data.dao.MovieDao
import com.example.brubankchallenge.data.entity.MovieEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalMoviesDataSourceImpl @Inject constructor(
    private val movieDao: MovieDao
) : LocalMoviesDataSource {
    override suspend fun addMovie(movie: MovieEntity) {
        movieDao.insertMovie(movie)
    }

    override fun getSubscriptionMovies(): Flow<List<MovieEntity>> {
        return movieDao.getSubscriptionMovies()
    }

    override suspend fun removeMovie(movie: MovieEntity) {
        movieDao.removeMovie(movie)
    }
}
