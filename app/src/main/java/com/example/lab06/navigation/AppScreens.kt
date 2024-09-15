package com.example.lab06.navigation

sealed class AppScreens(val route: String) {
    object PantallaInicio: AppScreens(route = "customScaffold")
    object Profile: AppScreens(route = "profile")
    object Settings: AppScreens(route = "settings")
}
