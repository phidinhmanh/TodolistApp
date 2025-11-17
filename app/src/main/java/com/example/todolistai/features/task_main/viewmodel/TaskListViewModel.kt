package com.example.todolistai.features.task_main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistai.core.data.repository.TaskRepository
import com.example.todolistai.core.data.local.model.Task
import kotlinx.coroutines.launch

class TaskListViewModel(private val taskRepository: TaskRepository) : ViewModel() {

    val tasks = taskRepository.getAllTasks()

    fun addTask(title: String) {
        viewModelScope.launch {
            taskRepository.insertTask(Task(title = title))
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            taskRepository.updateTask(task)
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            taskRepository.deleteTask(task)
        }
    }
}
