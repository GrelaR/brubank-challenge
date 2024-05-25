package com.example.brubankchallenge.ui.screens.main_screen.components

import com.example.brubankchallenge.domain.model.MovieGenresList

sealed class UIState {
    data object Loading : UIState()
    data class Success(val data: MovieGenresList) : UIState()
    data class GenericError(val message: String) : UIState()
    data class NetworkError(val message: String) : UIState()
}
