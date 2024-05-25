package com.example.brubankchallenge.domain.usecase

import com.example.brubankchallenge.domain.repository.GetMoviesByGenreRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val getMoviesByGenreRepository: GetMoviesByGenreRepository
) {
    suspend operator fun invoke() = getMoviesByGenreRepository.getMoviesByGenre()
}
