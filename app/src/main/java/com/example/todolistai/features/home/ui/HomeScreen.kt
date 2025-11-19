package com.example.todolistai.features.home.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todolistai.features.home.ui.components.CalendarSection
import com.example.todolistai.features.home.ui.components.TaskListSection
import com.example.todolistai.features.home.viewmodel.HomeViewModel
import com.example.todolistai.ui.components.CustomFloatingActionButton

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen() {
    // This is a simplified example. You'll need to provide the ViewModel properly.
    val viewModel: HomeViewModel = viewModel()
    val selectedDate by viewModel.selectedDate.collectAsState()
    val tasks by viewModel.tasksForSelectedDate.collectAsState()
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            CustomFloatingActionButton(onClick = { showBottomSheet = true })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            CalendarSection(
                selectedDate = selectedDate,
                onDateSelected = { date -> viewModel.selectDate(date) },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.9f) // Adjust weight as needed
                    .background(MaterialTheme.colorScheme.surface)
            )

            HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.outlineVariant)

            TaskListSection(
                tasks = tasks,
                onTaskComplete = { task -> viewModel.toggleComplete(task) },
                onTaskSwipeDelete = { task -> viewModel.deleteTask(task) },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.1f) // Adjust weight as needed
            )
        }
    }
}
