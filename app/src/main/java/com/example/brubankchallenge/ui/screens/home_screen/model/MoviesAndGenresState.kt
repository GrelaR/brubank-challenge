package com.example.brubankchallenge.ui.screens.home_screen.model

import androidx.paging.PagingData
import com.example.brubankchallenge.domain.model.Genre
import com.example.brubankchallenge.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow


data class MoviesAndGenresState(
    val movies: Flow<PagingData<Movie>> = emptyFlow(),
    val genres: List<Genre> = emptyList()
)

