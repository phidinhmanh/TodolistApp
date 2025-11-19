package com.example.todolistai.features.focus.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todolistai.features.focus.viewmodel.FocusViewModel

@Composable
fun FocusScreen(viewModel: FocusViewModel = viewModel()) {
    val timeInMillis by viewModel.timeInMillis.collectAsState()
    val isRunning by viewModel.isRunning.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = (timeInMillis / 1000).toString()) // Display time in seconds
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = { viewModel.startTimer() }, enabled = !isRunning) {
                Text("Start")
            }
            Button(onClick = { viewModel.pauseTimer() }, enabled = isRunning) {
                Text("Pause")
            }
        }
    }
}
