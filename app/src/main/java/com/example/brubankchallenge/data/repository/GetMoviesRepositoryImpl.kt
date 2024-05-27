package com.example.brubankchallenge.data.repository

import com.example.brubankchallenge.data.datasource.GetMoviesDataSource
import com.example.brubankchallenge.domain.model.MovieResponse
import com.example.brubankchallenge.domain.repository.GetMoviesRepository
import javax.inject.Inject

class GetMoviesRepositoryImpl @Inject constructor(
    private val getMoviesDataSource: GetMoviesDataSource
) : GetMoviesRepository {

    override suspend fun getTopRatedMovies(currentPage: Int): MovieResponse {
        return try {
            val response = getMoviesDataSource.getMovies(currentPage)
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
