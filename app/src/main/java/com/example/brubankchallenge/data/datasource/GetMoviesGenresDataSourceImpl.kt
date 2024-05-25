package com.example.brubankchallenge.data.datasource

import com.example.brubankchallenge.data.api.GetMoviesService
import com.example.brubankchallenge.domain.model.MovieGenresList
import javax.inject.Inject
import retrofit2.Response

class GetMoviesGenresDataSourceImpl @Inject constructor(
    private val getMoviesService: GetMoviesService
) : GetMoviesGenresDataSource {

    override suspend fun getMoviesGenresData(): Response<MovieGenresList> {
        return getMoviesService.getMovieGenres()
    }
}
