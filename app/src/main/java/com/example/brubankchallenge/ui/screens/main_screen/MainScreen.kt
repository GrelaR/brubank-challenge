package com.example.brubankchallenge.ui.screens.main_screen

import com.example.brubankchallenge.ui.screens.main_screen.components.UIState
import com.example.brubankchallenge.ui.screens.main_screen.viewmodel.MainScreenViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import com.example.brubankchallenge.ui.screens.home_screen.HomeScreen
import com.example.brubankchallenge.ui.screens.main_screen.components.ProgressBarScreen


@Composable
fun MainScreen(
    mainScreenViewModel: MainScreenViewModel = viewModel()
) {
    LaunchedEffect(key1 = true) {
        mainScreenViewModel.movies
    }
    val uiState = mainScreenViewModel.uiState.observeAsState(initial = UIState.Loading)

    when (uiState.value) {
        is UIState.Loading -> ProgressBarScreen()
        is UIState.Success -> HomeScreen(
            mainScreenViewModel = mainScreenViewModel
        )

        is UIState.GenericError -> {}
        is UIState.NetworkError -> {}

    }
}
