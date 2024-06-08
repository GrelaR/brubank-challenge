package com.example.brubankchallenge.ui.screens.home_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.brubankchallenge.BuildConfig
import com.example.brubankchallenge.R
import com.example.brubankchallenge.ui.nav.Routes
import com.example.brubankchallenge.ui.screens.home_screen.viewmodel.MainScreenViewModel


@Composable
fun SubscribedMoviesSection(
    navController: NavController,
    mainScreenViewModel: MainScreenViewModel
) {
    val subscriptionMovies by mainScreenViewModel.subscriptionMovies.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier.padding(24.dp)
    ) {
        Text(
            text = stringResource(R.string.subscribted),
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFF8f9090),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        LazyRow {
            items(subscriptionMovies.size) { index ->
                val movie = subscriptionMovies[index]
                SubscribedMovieItem(
                    posterPath = movie.posterPath,
                    onClickAction = {
                        navController.navigate(Routes.DetailScreen.withArgs(movie))
                    }
                )
            }
        }
    }
}
