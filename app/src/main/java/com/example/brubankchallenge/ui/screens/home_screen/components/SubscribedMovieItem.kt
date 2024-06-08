package com.example.brubankchallenge.ui.screens.home_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.brubankchallenge.BuildConfig

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SubscribedMovieItem(
    posterPath: String,
    onClickAction: () -> Unit
) {
    Box(
        modifier = Modifier
            .clickable { onClickAction() }
            .clip(RoundedCornerShape(4.dp))
    )
    GlideImage(
        model = BuildConfig.BASE_IMAGE_URL + posterPath,
        contentDescription = null,
        modifier = Modifier
            .width(130.dp)
            .height(200.dp)
            .padding(end = 8.dp)
            .clickable { onClickAction() },
        contentScale = ContentScale.Crop
    )
}
