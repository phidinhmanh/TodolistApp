package com.example.todolistai.core.data.repository

import com.example.todolistai.core.data.local.db.TaskDao
import com.example.todolistai.core.data.local.model.Task
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(private val taskDao: TaskDao) : TaskRepository {
    override fun getAllTasks(): Flow<List<Task>> = taskDao.getAllTasks()

    override suspend fun insertTask(task: Task) {
        taskDao.insertTask(task)
    }

    override suspend fun updateTask(task: Task) {
        taskDao.updateTask(task)
    }

    override suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(task)
    }
}
