package com.example.todolistai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.todolistai.core.navigation.AppNavigation
import com.example.todolistai.core.theme.ToDoListAITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoListAITheme {
                AppNavigation()
            }
        }
    }
}
