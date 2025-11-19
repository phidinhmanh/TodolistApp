package com.example.todolistai.features.home.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarSection(
    selectedDate: LocalDate,
    onDateSelected: (LocalDate) -> Unit,
    modifier: Modifier = Modifier
) {
    // Placeholder for a real calendar implementation
    // You would use a library like `io.github.boguszpawlowski.composecalendar:composecalendar` here
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "${selectedDate.month.name} ${selectedDate.year}")
        Text(text = "Calendar will be here. Selected: ${selectedDate.dayOfMonth}")
    }
}
