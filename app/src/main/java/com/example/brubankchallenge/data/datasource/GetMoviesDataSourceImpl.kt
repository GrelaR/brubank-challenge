package com.example.brubankchallenge.data.datasource

import com.example.brubankchallenge.data.api.GetMoviesService
import com.example.brubankchallenge.domain.model.MovieResponse
import javax.inject.Inject
import retrofit2.Response

class GetMoviesDataSourceImpl @Inject constructor(
    private val getMoviesService: GetMoviesService
) : GetMoviesDataSource {

    override suspend fun getMovies(currentPage: Int): Response<MovieResponse> {
        return getMoviesService.getMovieTopRated(page = currentPage)
    }


}
