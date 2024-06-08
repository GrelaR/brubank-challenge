package com.example.brubankchallenge.ui.screens.detail_screen

import android.graphics.Bitmap
import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.brubankchallenge.BuildConfig
import com.example.brubankchallenge.R
import com.example.brubankchallenge.domain.model.Movie
import com.example.brubankchallenge.ui.screens.home_screen.viewmodel.MainScreenViewModel
import com.example.brubankchallenge.utils.getContrastingTextColor
import com.example.brubankchallenge.utils.getDominantColor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailScreen(
    movie: Movie,
    navController: NavHostController,
    mainScreenViewModel: MainScreenViewModel
) {
    val context = LocalContext.current
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }
    var dominantColor by remember { mutableStateOf(Color.Black) }
    val scope = rememberCoroutineScope()
    val isSubscribed by mainScreenViewModel.isMovieSubscribed(movie).collectAsState(initial = false)

    LaunchedEffect(movie.posterPath) {
        scope.launch {
            val glideBitmap = withContext(Dispatchers.IO) {
                Glide.with(context)
                    .asBitmap()
                    .load(BuildConfig.BASE_IMAGE_URL + movie.posterPath)
                    .submit()
                    .get()
            }
            bitmap = glideBitmap
            dominantColor = getDominantColor(glideBitmap)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(dominantColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = stringResource(R.string.back),
            modifier = Modifier
                .align(Alignment.Start)
                .clickable { navController.popBackStack() }
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        GlideImage(
            model = BuildConfig.BASE_IMAGE_URL + movie.posterPath,
            contentDescription = null,
            modifier = Modifier
                .height(400.dp)
                .width(300.dp)
                .padding(16.dp),
            contentScale = ContentScale.Crop,
        )

        Text(
            text = movie.title,
            color = getContrastingTextColor(dominantColor),
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(
            text = movie.releaseDate,
            color = getContrastingTextColor(dominantColor),
            modifier = Modifier.padding(top = 8.dp)
        )

        OutlinedButton(
            onClick = { mainScreenViewModel.toggleMovieSubscription(movie) },
            shape = RoundedCornerShape(50),
            border = BorderStroke(2.dp, getContrastingTextColor(dominantColor)),
            modifier = Modifier
                .padding(top = 16.dp)
                .width(200.dp)
                .height(50.dp)
        ) {
            Text(
                text = if (isSubscribed) stringResource(R.string.suscripto) else stringResource(R.string.suscribirme),
                color = getContrastingTextColor(dominantColor)
            )
        }

        Column(
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.overview),
                color = getContrastingTextColor(dominantColor),
            )

            Text(
                text = movie.overview,
                color = getContrastingTextColor(dominantColor),
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}


