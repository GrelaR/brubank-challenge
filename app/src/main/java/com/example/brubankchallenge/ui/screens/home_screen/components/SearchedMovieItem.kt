package com.example.brubankchallenge.ui.screens.home_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.width
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SearchedMovieItem(title: String, posterPath: String, genre: String) {
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
                    model = BuildConfig.BASE_IMAGE_URL + posterPath,
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
                            text = title,
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = genre.uppercase(),
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color(0xFF606060)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                    ) {
                        OutlinedButton(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.outlinedButtonColors(
                                disabledContainerColor = Color.Transparent,
                                contentColor = Color(0xFF606060),
                                containerColor = Color.Transparent
                            ),
                            border = BorderStroke(1.dp, Color(0xFF606060)),
                            shape = RoundedCornerShape(4.dp),
                            modifier = Modifier
                                .height(24.dp)
                                .padding(end = 16.dp),
                            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
                        ) {
                            Text(
                                text = stringResource(R.string.agregar),
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(0xFF606060)
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

@Composable
@Preview
fun SearchedMovieItemPreview() {
    SearchedMovieItem(
        title = "El padrino",
        posterPath = "/wuMc08IPKEatf9rnMNXvIDxqP4W.jpg",
        genre = "Animada"
    )
}



