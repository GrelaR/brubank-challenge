package com.example.brubankchallenge.data.repository

import com.example.brubankchallenge.data.datasource.GetGenresDataSource
import com.example.brubankchallenge.domain.model.MovieGenresResponse
import com.example.brubankchallenge.domain.repository.GetGenresRepository
import javax.inject.Inject

class GetGenresRepositoryImpl @Inject constructor(
    private val getGenresDataSource: GetGenresDataSource
) : GetGenresRepository {
    override suspend fun getMovieGenres(): MovieGenresResponse {
        return try {
            val response = getGenresDataSource.getMoviesGenres()
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
