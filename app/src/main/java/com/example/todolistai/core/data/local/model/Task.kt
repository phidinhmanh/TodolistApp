package com.example.todolistai.core.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey


enum class CreationMethod {
    VOICE,
    MANUAL
}

enum class TaskCategory {
    WORK,
    PERSONAL,
    SHOPPING
}



@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val details: String,
    val title: String,
    val category: TaskCategory,
    val createAt: Long = System.currentTimeMillis(),
    val dueDate: Long? = null,
    val isCompleted: Boolean = false,
    val creationMethod: CreationMethod
)
