package com.example.todolistai.features.notifications.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class TaskReminderWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        // Implement the logic for sending a notification
        return Result.success()
    }
}
