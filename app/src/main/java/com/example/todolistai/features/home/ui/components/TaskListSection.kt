package com.example.todolistai.features.home.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.todolistai.core.data.local.model.Task

@Composable
fun TaskListSection(
    tasks: List<Task>,
    onTaskComplete: (Task) -> Unit,
    onTaskSwipeDelete: (Task) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(tasks, key = { it.id }) { task ->

        }
    }
}
