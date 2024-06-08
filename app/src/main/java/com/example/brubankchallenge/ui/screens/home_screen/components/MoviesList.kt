package com.example.brubankchallenge.ui.screens.home_screen.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.example.brubankchallenge.ui.screens.home_screen.viewmodel.MainScreenViewModel


@Composable
fun MoviesList(
    navController: NavController,
    mainScreenViewModel: MainScreenViewModel
) {
    val subscriptionMovies by mainScreenViewModel.subscriptionMovies.collectAsState(initial = emptyList())

    if (subscriptionMovies.isNotEmpty())
        SubscribedMoviesSection(
            navController = navController,
            mainScreenViewModel = mainScreenViewModel
        )
    TopRatedMoviesSection(
        navController = navController,
        mainScreenViewModel = mainScreenViewModel
    )
}
