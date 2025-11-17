package com.example.todolistai.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todolistai.features.task_main.ui.TaskListScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenRoutes.TaskList.route) {
        composable(ScreenRoutes.TaskList.route) {
            TaskListScreen()
        }
        // Add other composables for other screens here
    }
}
