package com.example.todolistai.features.voice.ui

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun VoiceInputDialog(
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {
    // This is a placeholder for a real voice input dialog.
    // You would integrate SpeechRecognizerHandler here.
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Voice Input") },
        text = { Text("Listening...") },
        confirmButton = {
            TextButton(onClick = { onConfirm("A sample task from voice") }) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
