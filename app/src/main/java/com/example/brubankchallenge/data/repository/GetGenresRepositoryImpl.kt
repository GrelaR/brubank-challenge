package com.example.brubankchallenge.data.repository

import com.example.brubankchallenge.data.datasource.GetGenresDataSource
import com.example.brubankchallenge.data.mapper.toGenresDomain
import com.example.brubankchallenge.domain.model.Genre
import com.example.brubankchallenge.domain.repository.GetGenresRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetGenresRepositoryImpl @Inject constructor(
    private val getGenresDataSource: GetGenresDataSource
) : GetGenresRepository {
    override fun getMovieGenres(): Flow<List<Genre>> = flow {
        val response = getGenresDataSource.getMoviesGenres()
        if (response.isSuccessful) {
            response.body()?.let { genreResponse ->
                emit(genreResponse.genres.toGenresDomain())
            } ?: emit(emptyList())
        } else {
            emit(emptyList())
        }
    }
}
