package com.example.brubankchallenge.ui.screens.home_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.brubankchallenge.ui.screens.home_screen.model.MoviesAndGenresState
import com.example.brubankchallenge.ui.screens.home_screen.viewmodel.MainScreenViewModel


@Composable
fun SearchedMoviesList(
    mainScreenViewModel: MainScreenViewModel
) {
    val combinedData by mainScreenViewModel.combinedData.collectAsState(initial = MoviesAndGenresState())
    val movies = combinedData.movies.collectAsLazyPagingItems()

    LazyColumn(
        contentPadding = PaddingValues(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movies.itemCount) { movieItem ->
            movies[movieItem]?.let { movie ->
                SearchedMovieItem(
                    title = movie.title,
                    posterPath = movie.posterPath,
                    genre = mainScreenViewModel.getPrimaryGenreForMovie(movie) ?: ""
                )
            }
        }
        movies.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item(key = 1) {
                        Box(
                            modifier = Modifier
                                .fillParentMaxSize()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }

                loadState.append is LoadState.Loading -> {
                    item(key = 2) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }

                loadState.append is LoadState.Error -> {
                    val e = movies.loadState.append as LoadState.Error
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Error: ${e.error.localizedMessage}",
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                    }
                }
            }
        }
    }
}
