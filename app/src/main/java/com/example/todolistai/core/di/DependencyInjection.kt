package com.example.todolistai.core.di

import android.content.Context
import androidx.room.Room
import com.example.todolistai.core.data.local.db.TaskDatabase
import com.example.todolistai.core.data.repository.TaskRepository
import com.example.todolistai.core.data.repository.TaskRepositoryImpl

object DependencyInjection {
    private var database: TaskDatabase? = null
    private fun provideDatabase(context: Context): TaskDatabase {
        return database ?: synchronized(this) {
            database ?: Room.databaseBuilder(
                context.applicationContext,
                TaskDatabase::class.java,
                "task_database"
            ).build().also { database = it }
        }
    }

    fun provideTaskRepository(context: Context): TaskRepository {
        return TaskRepositoryImpl(provideDatabase(context).taskDao())
    }
}
