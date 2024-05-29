package com.example.brubankchallenge.ui.screens.home_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.brubankchallenge.domain.model.Movie
import com.example.brubankchallenge.domain.usecase.GetGenresUseCase
import com.example.brubankchallenge.domain.usecase.GetMoviesUseCase
import com.example.brubankchallenge.domain.usecase.SearchMoviesUseCase
import com.example.brubankchallenge.ui.screens.home_screen.model.MoviesAndGenresState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getGenresUseCase: GetGenresUseCase,
    private val searchMoviesUseCase: SearchMoviesUseCase
) : ViewModel() {
    private val _genres = getGenresUseCase()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _moviesState: Flow<PagingData<Movie>> = searchQuery.flatMapLatest { query ->
        if (query.isEmpty()) {
            getMoviesUseCase().cachedIn(viewModelScope)
        } else {
            searchMoviesUseCase(query).cachedIn(viewModelScope)
        }
    }

    val combinedData: Flow<MoviesAndGenresState> = combine(
        _moviesState,
        _genres
    ) { moviesState, genres ->
        MoviesAndGenresState(movies = flowOf(moviesState), genres = genres)
    }

    fun getPrimaryGenreForMovie(movie: Movie): String? {
        val genresMap = _genres.value.associateBy { it.id }
        return movie.genreIds.firstOrNull()?.let { genreId ->
            genresMap[genreId]?.name
        }
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
    }
}






