package com.example.brubankchallenge.ui.nav

import com.example.brubankchallenge.ui.screens.main_screen.components.ProgressBarScreen
import com.example.brubankchallenge.ui.screens.main_screen.viewmodel.MainScreenViewModel
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.brubankchallenge.ui.screens.home_screen.HomeScreen
import com.example.brubankchallenge.ui.screens.main_screen.MainScreen

const val MAIN_SCREEN = "main_screen"
const val GENERIC_ERROR_SCREEN = "generic_error_screen"
const val CONNECTION_ERROR_SCREEN = "connection_error_screen"
const val POP_BACK_STACK = "pop_back_stack"
const val LOADING_SCREEN = "loading_screen"

@Composable
fun Navigation(startDestination: String = MAIN_SCREEN) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable(MAIN_SCREEN) {
            val mainScreenViewModel = hiltViewModel<MainScreenViewModel>()
            HomeScreen(mainScreenViewModel)
        }
        composable(GENERIC_ERROR_SCREEN) {

        }
//        composable(CONNECTION_ERROR_SCREEN) {
//            ConnectionErrorScreen(retryAction = {
//                navController.navigate(MAIN_SECURITY_CENTER_SCREEN) {
//                    popUpTo(MAIN_SECURITY_CENTER_SCREEN) {
//                        inclusive = true
//                    }
//                }
//            })
//        }

        composable(LOADING_SCREEN) {
            ProgressBarScreen()
        }
    }
}
