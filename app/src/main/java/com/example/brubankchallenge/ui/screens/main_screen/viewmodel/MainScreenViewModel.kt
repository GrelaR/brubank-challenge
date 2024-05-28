package com.example.brubankchallenge.ui.screens.main_screen.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.brubankchallenge.domain.model.Movie
import com.example.brubankchallenge.domain.usecase.GetGenresUseCase
import com.example.brubankchallenge.domain.usecase.GetMoviesUseCase
import com.example.brubankchallenge.ui.screens.main_screen.components.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getGenresUseCase: GetGenresUseCase
) : ViewModel() {
    private val _uiState: MutableLiveData<UIState> = MutableLiveData()
    val uiState: MutableLiveData<UIState> get() = _uiState

    init {
        viewModelScope.launch {
            getGenresUseCase()
        }
    }
        val movies: Flow<PagingData<Movie>> = getMoviesUseCase()
            .cachedIn(viewModelScope)
    }





