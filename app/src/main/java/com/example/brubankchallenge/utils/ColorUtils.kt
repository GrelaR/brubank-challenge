package com.example.brubankchallenge.utils

import android.graphics.Bitmap
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.palette.graphics.Palette
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun getDominantColor(bitmap: Bitmap): Color = withContext(Dispatchers.Default) {
    val palette = Palette.from(bitmap).generate()
    val dominantSwatch = palette.dominantSwatch
    Color(dominantSwatch?.rgb ?: 0x000000)
}

private fun Color.isLight(): Boolean {
    return this.luminance() > 0.5
}

fun getContrastingTextColor(backgroundColor: Color): Color {
    return if (backgroundColor.isLight()) Color.Black else Color.White
}
