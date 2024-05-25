package com.example.brubankchallenge.data.repository

import com.example.brubankchallenge.data.datasource.GetMoviesGenresDataSource
import com.example.brubankchallenge.domain.model.TopRatedMovies
import com.example.brubankchallenge.domain.repository.GetMoviesByGenreRepository
import javax.inject.Inject

class GetMoviesByGenreRepositoryImpl @Inject constructor(
    private val getMoviesByGenresDataSource: GetMoviesGenresDataSource
) : GetMoviesByGenreRepository {

    override suspend fun getMoviesByGenre(): TopRatedMovies {
        return try {
            val response = getMoviesByGenresDataSource.getMoviesGenresData()
            if (response.isSuccessful) {
                response.body()!!
            } else {
                throw Exception("Response body is null")
            }
        } catch (exception: Exception) {
            throw exception
        }

    }
}
