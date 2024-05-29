package com.example.brubankchallenge.ui.screens.home_screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.brubankchallenge.ui.screens.home_screen.viewmodel.MainScreenViewModel

@Composable
fun SearchTopBar(
    mainScreenViewModel: MainScreenViewModel = hiltViewModel()
) {
    val searchQuery by mainScreenViewModel.searchQuery.collectAsState()

    TextField(
        value = searchQuery,
        onValueChange = { mainScreenViewModel.onSearchQueryChanged(it) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        placeholder = {
            Text(text = "Search movies...", style = MaterialTheme.typography.bodyLarge)
        }
    )
}
