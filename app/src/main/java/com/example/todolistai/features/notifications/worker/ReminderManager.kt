package com.example.todolistai.features.notifications.worker
import com.example.todolistai.core.data.local.model.Task

interface ReminderManager {

    fun scheduleReminder(task: Task)

    fun cancelReminder(taskId: Long)
}
