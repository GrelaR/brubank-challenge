package com.example.brubankchallenge.ui.screens.main_screen.viewmodel

import android.accounts.NetworkErrorException
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {
    private val _uiState: MutableLiveData<UIState> = MutableLiveData()
    val uiState: MutableLiveData<UIState> get() = _uiState
    fun getMovies() {
        _uiState.value = UIState.Loading
        viewModelScope.launch {
            try {
                val data = getMoviesUseCase()
                _uiState.value = UIState.Success(data)
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



