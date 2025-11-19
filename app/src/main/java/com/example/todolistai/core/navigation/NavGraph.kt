package com.example.todolistai.core.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todolistai.features.analytics.ui.AnalyticsScreen
import com.example.todolistai.features.focus.ui.FocusScreen
import com.example.todolistai.features.home.ui.HomeScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController, startDestination = ScreenRoutes.Home.route, modifier = modifier) {
        composable(ScreenRoutes.Home.route) { HomeScreen() }
        composable(ScreenRoutes.Focus.route) { FocusScreen() }
        composable(ScreenRoutes.Analytics.route) { AnalyticsScreen() }
    }
}
