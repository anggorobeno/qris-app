package com.example.qrisapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.qrisapp.feature.camera.ui.CameraScreen
import com.example.qrisapp.feature.main.ui.HomeScreen
import com.example.qrisapp.feature.main.ui.MainScreen
import com.example.qrisapp.feature.qrisscanner.ui.QrisScreen


const val QRIS_HOME = "qris-home"
const val HOME_SCREEN = "home-screen"
const val SCREEN = "screen"
const val CAMERA_SCREEN = "camera-screen"

val listScreen = listOf(
    HOME_SCREEN, QRIS_HOME
)

@Composable
fun QrisNavigation(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = HOME_SCREEN
    ) {
        composable(route = QRIS_HOME) {
            QrisScreen(navHostController = navController)
        }
        composable(route = HOME_SCREEN) {
            MainScreen(navController) {
                navController.navigate(it)
            }
        }
        composable(route = SCREEN) {
            HomeScreen()
        }
        composable(route = CAMERA_SCREEN) { CameraScreen() }
    }
}
