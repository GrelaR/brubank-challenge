package com.example.brubankchallenge.domain.usecase

import com.example.brubankchallenge.domain.repository.GetMoviesRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val getMovieRepository: GetMoviesRepository
) {
    suspend operator fun invoke(currentPage: Int) =
        getMovieRepository.getTopRatedMovies(currentPage)
}
