package com.example.lab06.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab06.screens.CustomScaffold
import com.example.lab06.screens.Profile
import com.example.lab06.screens.Settings
import com.example.lab06.screens.Info

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.PantallaInicio.route) {
        composable(route = AppScreens.PantallaInicio.route) {
            CustomScaffold(navController)
        }
        composable(route = AppScreens.Profile.route) {
            Profile(navController)
        }
        composable(route = AppScreens.Settings.route) {
            Settings(navController)
        }
        composable(route = AppScreens.Info.route) {
            Info(navController)
        }
    }
}
