package com.example.brubankchallenge.domain.usecase

import com.example.brubankchallenge.domain.model.Genre
import com.example.brubankchallenge.domain.repository.GetGenresRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetGenresUseCase @Inject constructor(
    private val getGenresRepository: GetGenresRepository
) {
     operator fun invoke(): Flow<List<Genre>> {
        return getGenresRepository.getMovieGenres()
    }
}
