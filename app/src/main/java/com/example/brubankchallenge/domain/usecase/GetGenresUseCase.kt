package com.example.brubankchallenge.domain.usecase

import com.example.brubankchallenge.domain.repository.GetGenresRepository
import javax.inject.Inject

class GetGenresUseCase @Inject constructor(
    private val getGenresRepository: GetGenresRepository
) {
    suspend operator fun invoke() = getGenresRepository.getMovieGenres()
}
