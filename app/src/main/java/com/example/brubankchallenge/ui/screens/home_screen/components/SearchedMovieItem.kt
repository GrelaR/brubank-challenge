package com.example.brubankchallenge.ui.screens.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.width
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SearchedMovieItem(title: String, posterPath: String, genre: String) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
            .background(Color(0xFF1B1B1B))

    ) {
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxHeight()
        ) {
            GlideImage(
                model = "https://image.tmdb.org/t/p/w500${posterPath}",
                contentDescription = null,
                modifier = Modifier
                    .width(50.dp)
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )
                Text(
                    text = genre,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )
            }
        }
        Column(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(
                    text = "Agregar",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )
            }

        }

    }

}


@Composable
@Preview
fun SearchedMovieItemPreview() {
    SearchedMovieItem(
        title = "El padrino",
        posterPath = "/wuMc08IPKEatf9rnMNXvIDxqP4W.jpg",
        genre = "Animada"
    )
}



