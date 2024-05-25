package com.example.brubankchallenge.ui.screens.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.brubankchallenge.domain.model.TopRatedMovies
import com.example.brubankchallenge.ui.screens.home_screen.components.MovieItem

@Composable
fun HomeScreen(
    topRatedMovies: TopRatedMovies
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1b1b1c))
    ) {
        Text(
            text = "Recomendadas",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(topRatedMovies.movies.size) {

                topRatedMovies.movies[it].title?.let { title ->
                    topRatedMovies.movies[it].posterPath?.let { posterPath ->
                        MovieItem(
                            title = title,
                            posterPath = posterPath
                        )
                    }
                }
            }
        }
    }

}

