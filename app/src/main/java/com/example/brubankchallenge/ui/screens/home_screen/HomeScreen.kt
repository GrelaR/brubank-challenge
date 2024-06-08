package com.example.brubankchallenge.ui.screens.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.brubankchallenge.ui.screens.home_screen.components.SearchTopBar
import com.example.brubankchallenge.ui.screens.home_screen.components.SearchedMoviesList
import com.example.brubankchallenge.ui.screens.home_screen.components.MoviesList
import com.example.brubankchallenge.ui.screens.home_screen.viewmodel.MainScreenViewModel
import com.example.brubankchallenge.ui.theme.mainScreenBackgroundColor

@Composable
fun HomeScreen(
    navController: NavController,
    mainScreenViewModel: MainScreenViewModel
) {
    val searchState = mainScreenViewModel.searchQuery.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(mainScreenBackgroundColor)
    ) {
        SearchTopBar(
            mainScreenViewModel = mainScreenViewModel
        )
        if (searchState.value.isEmpty()) {
            MoviesList(
                navController = navController,
                mainScreenViewModel = mainScreenViewModel
            )
        } else {
            SearchedMoviesList(mainScreenViewModel = mainScreenViewModel)
        }
    }
}

