package com.example.brubankchallenge.ui.screens.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.brubankchallenge.ui.screens.home_screen.components.LoadingAnimation
import com.example.brubankchallenge.ui.screens.home_screen.components.SearchTopBar
import com.example.brubankchallenge.ui.screens.home_screen.components.SearchedMoviesList
import com.example.brubankchallenge.ui.screens.home_screen.components.SubscribedMoviesSection
import com.example.brubankchallenge.ui.screens.home_screen.components.TopRatedMoviesList
import com.example.brubankchallenge.ui.screens.home_screen.viewmodel.MainScreenViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    mainScreenViewModel: MainScreenViewModel
) {
    val searchState = mainScreenViewModel.searchQuery.collectAsState()
    val loading = mainScreenViewModel.loading.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1B1B1B))
    ) {
        if (loading.value) {
            LoadingAnimation()
        } else {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF151414))
            ) {
                SearchTopBar(
                    mainScreenViewModel = mainScreenViewModel
                )
            }
            if (searchState.value.isEmpty()) {
                TopRatedMoviesList(
                    navController = navController,
                    mainScreenViewModel = mainScreenViewModel
                )
            } else {
                SearchedMoviesList(mainScreenViewModel = mainScreenViewModel)
            }
        }
    }
}
