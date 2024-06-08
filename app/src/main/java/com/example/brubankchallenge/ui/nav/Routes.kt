package com.example.brubankchallenge.ui.nav

import android.net.Uri
import com.example.brubankchallenge.domain.model.Movie
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement

sealed class Routes(val route: String) {
    data object MainScreen : Routes("main_screen")
    data object DetailScreen : Routes("detail_screen/{movie}") {
        fun withArgs(movie: Movie) =
            "detail_screen/${Uri.encode(Json.encodeToJsonElement(movie).toString())}"
    }
}
