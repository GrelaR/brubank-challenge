package com.example.brubankchallenge.ui.nav

import com.example.brubankchallenge.ui.screens.home_screen.components.ProgressBarScreen
import com.example.brubankchallenge.ui.screens.home_screen.viewmodel.MainScreenViewModel
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.brubankchallenge.ui.screens.detail_screen.DetailScreen
import com.example.brubankchallenge.ui.screens.home_screen.HomeScreen

const val MAIN_SCREEN = "main_screen"
const val GENERIC_ERROR_SCREEN = "generic_error_screen"
const val LOADING_SCREEN = "loading_screen"
const val DETAIL_SCREEN = "detail_screen"

@Composable
fun Navigation(startDestination: String = MAIN_SCREEN) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable(MAIN_SCREEN) {
            val mainScreenViewModel = hiltViewModel<MainScreenViewModel>()
            HomeScreen(navController, mainScreenViewModel)
        }
        composable(
            route = "detail_screen/{title}/{posterPath}/{overview}/{releaseDate}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("posterPath") { type = NavType.StringType },
                navArgument("overview") { type = NavType.StringType },
                navArgument("releaseDate") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val posterPath = backStackEntry.arguments?.getString("posterPath") ?: ""
            val overview = backStackEntry.arguments?.getString("overview") ?: ""
            val releaseDate = backStackEntry.arguments?.getString("releaseDate") ?: ""
            DetailScreen(
                title = title,
                posterPath = posterPath,
                overview = overview,
                releaseDate = releaseDate,
                navController = navController
            )
        }

        composable(LOADING_SCREEN) {
            ProgressBarScreen()
        }
    }
}
