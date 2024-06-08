package com.example.brubankchallenge.ui.nav

import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.brubankchallenge.ui.screens.home_screen.viewmodel.MainScreenViewModel
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.brubankchallenge.domain.model.Movie
import com.example.brubankchallenge.ui.screens.detail_screen.DetailScreen
import com.example.brubankchallenge.ui.screens.home_screen.HomeScreen
import kotlinx.serialization.json.Json

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.MainScreen.route) {
        composable(Routes.MainScreen.route) {
            val mainScreenViewModel = hiltViewModel<MainScreenViewModel>()
            HomeScreen(navController, mainScreenViewModel)
        }
        composable(
            route = Routes.DetailScreen.route,
            arguments = listOf(navArgument("movie") {
                type = MovieNavType
            })
        ) { backStackEntry ->
            val movie = backStackEntry.arguments?.getParcelable("movie", Movie::class.java)
            val mainScreenViewModel = hiltViewModel<MainScreenViewModel>()
            if (movie != null) {
                DetailScreen(
                    movie = movie,
                    navController = navController,
                    mainScreenViewModel = mainScreenViewModel
                )
            }
        }

    }
}


val MovieNavType = object : NavType<Movie>(isNullableAllowed = true) {
    override fun put(bundle: Bundle, key: String, value: Movie) {
        bundle.putParcelable(key, value)
    }

    override fun get(bundle: Bundle, key: String): Movie? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, Movie::class.java)
        } else {
            TODO("VERSION.SDK_INT < TIRAMISU")
        }
    }

    override fun parseValue(value: String): Movie {
        return Json.decodeFromString(Uri.decode(value))
    }

}
