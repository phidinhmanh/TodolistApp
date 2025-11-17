package com.example.todolistai.core.navigation

sealed class ScreenRoutes(val route: String) {
    object TaskList : ScreenRoutes("task_list")
    object Analytics : ScreenRoutes("analytics")
}
