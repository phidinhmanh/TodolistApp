package com.example.todolistai.core.navigation

sealed class ScreenRoutes(val route: String) {
    object Home : ScreenRoutes("home")
    object Focus : ScreenRoutes("focus")
    object Analytics : ScreenRoutes("analytics")
}
