package com.example.brubankchallenge.ui.screens.home_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.brubankchallenge.BuildConfig
import com.example.brubankchallenge.R
import com.example.brubankchallenge.domain.model.Movie
import com.example.brubankchallenge.ui.screens.home_screen.viewmodel.MainScreenViewModel


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SearchedMovieItem(
    movie: Movie,
    mainScreenViewModel: MainScreenViewModel
) {
    val isSubscribed by mainScreenViewModel.isMovieSubscribed(movie).collectAsState(initial = false)

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(start = 24.dp)
                .background(Color(0xFF1B1B1B))
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxHeight()
                    .fillMaxWidth()

            ) {
                GlideImage(
                    model = BuildConfig.BASE_IMAGE_URL + movie.posterPath,
                    contentDescription = null,
                    modifier = Modifier
                        .width(60.dp)
                        .fillMaxHeight()
                        .padding(vertical = 8.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop

                )
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .fillMaxWidth(0.5f)
                    ) {
                        Text(
                            text = movie.title,
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        mainScreenViewModel.getPrimaryGenreForMovie(movie)?.uppercase()?.let {
                            Text(
                                text = it,
                                style = MaterialTheme.typography.bodyLarge,
                                color = Color(0xFF606060)
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                    ) {
                        OutlinedButton(
                            onClick = {
                                mainScreenViewModel.toggleMovieSubscription(movie)
                            },
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = Color(0xFF606060),
                                containerColor = if (isSubscribed) Color(
                                    0xFF757676
                                ) else Color.Transparent,
                            ),
                            border = BorderStroke(1.dp, Color(0xFF606060)),
                            shape = RoundedCornerShape(4.dp),
                            modifier = Modifier
                                .height(24.dp)
                                .padding(end = 16.dp),
                            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
                        ) {
                            Text(
                                text = if (isSubscribed) stringResource(id = R.string.agregado)
                                else stringResource(
                                    id = R.string.agregar
                                ),
                                style = MaterialTheme.typography.bodySmall,
                                color = if (isSubscribed) Color.Black else Color(0xFF606060)
                            )
                        }
                    }

                }

            }
            HorizontalDivider(
                modifier = Modifier.padding(start = 76.dp),
                color = Color(0xFF606060),
                thickness = 0.5.dp,
            )
        }
    }
}



