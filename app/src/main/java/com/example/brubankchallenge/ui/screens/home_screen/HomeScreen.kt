package com.example.brubankchallenge.ui.screens.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.brubankchallenge.domain.model.Movie
import com.example.brubankchallenge.ui.screens.home_screen.components.MovieItem
import com.example.brubankchallenge.ui.screens.main_screen.components.UIState
import com.example.brubankchallenge.ui.screens.main_screen.viewmodel.MainScreenViewModel

@Composable
fun HomeScreen(
    mainScreenViewModel: MainScreenViewModel
) {
    val movies = mainScreenViewModel.movies.collectAsLazyPagingItems()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1B1B1B))
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

            items(movies.itemCount) { movie ->
                movies[movie]?.title?.let { title ->
                    movies[movie]?.posterPath?.let { posterPath ->
                        MovieItem(
                            title = title,
                            posterPath = posterPath
                        )
                    }
                }
            }
            when (movies.loadState.append) {
                is LoadState.Loading -> {
                    item {
                            CircularProgressIndicator()
                        }
                    }

                is LoadState.Error -> {}
                is LoadState.NotLoading -> {}
            }
//            item {
//                if (mainScreenViewModel.currentPage <= mainScreenViewModel.totalPage) {
//                    LaunchedEffect(Unit) {
//                        mainScreenViewModel.getMovies()
//                    }
//                    CircularProgressIndicator(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(16.dp)
//                    )
//                }
//            }

            }

    }

}

