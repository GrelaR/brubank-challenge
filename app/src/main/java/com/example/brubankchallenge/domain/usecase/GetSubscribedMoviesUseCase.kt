package com.example.brubankchallenge.domain.usecase

import com.example.brubankchallenge.domain.model.Movie
import com.example.brubankchallenge.domain.repository.MovieRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetSubscribedMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): Flow<List<Movie>> {
        return movieRepository.getSubscriptionMovies()
    }
}
