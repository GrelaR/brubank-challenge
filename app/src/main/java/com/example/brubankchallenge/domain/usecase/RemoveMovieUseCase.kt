package com.example.brubankchallenge.domain.usecase

import com.example.brubankchallenge.domain.model.Movie
import com.example.brubankchallenge.domain.repository.MovieRepository
import javax.inject.Inject

class RemoveMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(movie: Movie) {
        movieRepository.removeMovie(movie)
    }
}
