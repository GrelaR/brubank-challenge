package com.example.brubankchallenge.data.datasource

import com.example.brubankchallenge.data.api.GetMoviesService
import com.example.brubankchallenge.data.dto.MovieResponseDto
import javax.inject.Inject
import retrofit2.Response

class SearchMoviesDataSourceImpl @Inject constructor(
    private val getMoviesService: GetMoviesService
) : SearchMoviesDataSource {
    override suspend fun searchMovies(query: String, page: Int): Response<MovieResponseDto> {
        return getMoviesService.searchMovies(query, page)
    }
}
