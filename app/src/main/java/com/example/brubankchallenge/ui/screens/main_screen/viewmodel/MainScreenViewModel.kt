package com.example.brubankchallenge.ui.screens.main_screen.viewmodel

import android.accounts.NetworkErrorException
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.brubankchallenge.domain.usecase.GetGenresUseCase
import com.example.brubankchallenge.domain.usecase.GetMoviesUseCase
import com.example.brubankchallenge.ui.screens.main_screen.components.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject
import kotlinx.coroutines.launch
import retrofit2.HttpException

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getGenresUseCase: GetGenresUseCase
) : ViewModel() {
    private val _uiState: MutableLiveData<UIState> = MutableLiveData()
    val uiState: MutableLiveData<UIState> get() = _uiState

    var currentPage = 1
    var totalPage = 1

    init {
        viewModelScope.launch {
            getGenresUseCase()
        }
    }

    fun getMovies() {
        if (currentPage > totalPage) return

        viewModelScope.launch {
            try {
                val response = getMoviesUseCase.invoke(currentPage)
                totalPage = response.totalPages
                val currentMovieList = (_uiState.value as? UIState.Success)?.data ?: emptyList()
                _uiState.value = UIState.Success(currentMovieList + response.results)
                currentPage++
            } catch (e: Exception) {
                _uiState.value = when (e) {
                    is HttpException,
                    is NetworkErrorException,
                    is IOException,
                    is SocketTimeoutException -> {
                        UIState.NetworkError(e.localizedMessage ?: "")
                    }

                    else -> {
                        UIState.GenericError(e.localizedMessage ?: "Unknown error")
                    }
                }
            }

        }
    }
}



