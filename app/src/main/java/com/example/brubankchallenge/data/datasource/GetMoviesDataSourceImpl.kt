package com.example.brubankchallenge.data.datasource

import com.example.brubankchallenge.data.api.GetMoviesService
import com.example.brubankchallenge.data.dto.MovieResponseDto
import retrofit2.Response
import javax.inject.Inject

class GetMoviesDataSourceImpl @Inject constructor(
    private val getMoviesService: GetMoviesService
) : GetMoviesDataSource {

    override suspend fun getMovies(page: Int): Response<MovieResponseDto> {
        return getMoviesService.getMovieTopRated(page)
    }
}
