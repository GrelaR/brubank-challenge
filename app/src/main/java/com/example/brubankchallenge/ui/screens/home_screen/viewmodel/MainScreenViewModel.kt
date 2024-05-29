package com.example.brubankchallenge.ui.screens.home_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.brubankchallenge.domain.model.Movie
import com.example.brubankchallenge.domain.usecase.GetGenresUseCase
import com.example.brubankchallenge.domain.usecase.GetMoviesUseCase
import com.example.brubankchallenge.ui.screens.home_screen.model.MoviesAndGenresState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getGenresUseCase: GetGenresUseCase
) : ViewModel() {
    private val _genres = getGenresUseCase()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    private val _moviesState: Flow<PagingData<Movie>> = getMoviesUseCase()
        .cachedIn(viewModelScope)

    val combinedData: Flow<MoviesAndGenresState> = combine(
        _moviesState,
        _genres
    ) { moviesState, genres ->
        MoviesAndGenresState(movies = flowOf(moviesState), genres = genres)
    }

    fun getGenresForMovie(movie: Movie): List<String> {
        return _genres.value.filter { genre ->
            movie.genreIds.contains(genre.id)
        }.map { it.name }
    }
}






