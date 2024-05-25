package com.example.brubankchallenge.data.datasource

import com.example.brubankchallenge.data.api.GetMoviesService
import com.example.brubankchallenge.domain.model.TopRatedMovies
import javax.inject.Inject
import retrofit2.Response

class GetMoviesGenresDataSourceImpl @Inject constructor(
    private val getMoviesService: GetMoviesService
) : GetMoviesGenresDataSource {

    override suspend fun getMoviesGenresData(): Response<TopRatedMovies> {
        return getMoviesService.getMovieGenres()
    }
}
