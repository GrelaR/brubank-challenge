package com.example.brubankchallenge.ui.screens.home_screen.components

import com.example.brubankchallenge.domain.model.Movie

sealed class UIState {
    data object Loading : UIState()
    data class Success(val data: List<Movie>) : UIState()
    data class GenericError(val message: String) : UIState()
    data class NetworkError(val message: String) : UIState()
}
