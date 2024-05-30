package com.example.brubankchallenge.data.datasource

import com.example.brubankchallenge.data.api.GetMoviesService
import com.example.brubankchallenge.data.dto.GenresResponseDto
import javax.inject.Inject
import retrofit2.Response

class GetGenresDataSourceImpl @Inject constructor(
    private val getMoviesService: GetMoviesService
) : GetGenresDataSource {

    override suspend fun getMoviesGenres(): Response<GenresResponseDto> {
        return getMoviesService.getMovieGenres()
    }

}
