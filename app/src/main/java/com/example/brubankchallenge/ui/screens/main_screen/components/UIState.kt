package com.example.brubankchallenge.ui.screens.main_screen.components

import com.example.brubankchallenge.domain.model.Movie
import com.example.brubankchallenge.domain.model.TopRatedMovies

sealed class UIState {
    data object Loading : UIState()
    data class Success(val data: List<Movie>) : UIState()
    data class GenericError(val message: String) : UIState()
    data class NetworkError(val message: String) : UIState()
}
