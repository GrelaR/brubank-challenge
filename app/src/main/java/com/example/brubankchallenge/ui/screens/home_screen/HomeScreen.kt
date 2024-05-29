package com.example.brubankchallenge.ui.screens.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.brubankchallenge.ui.screens.home_screen.components.SearchTopBar
import com.example.brubankchallenge.ui.screens.home_screen.components.SearchedMoviesList
import com.example.brubankchallenge.ui.screens.home_screen.components.TopRatedMoviesList
import com.example.brubankchallenge.ui.screens.home_screen.viewmodel.MainScreenViewModel

@Composable
fun HomeScreen(
    mainScreenViewModel: MainScreenViewModel
) {
    val searchState = mainScreenViewModel.searchQuery.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1B1B1B))
    ) {
        SearchTopBar(mainScreenViewModel = mainScreenViewModel)
        if (searchState.value.isEmpty()) {
            Text(
                text = "Recomendadas",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )
            TopRatedMoviesList(mainScreenViewModel = mainScreenViewModel)
        } else {
            SearchedMoviesList(mainScreenViewModel = mainScreenViewModel)
        }
    }

}


