package com.example.todolistai.core.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolistai.core.data.local.model.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}
