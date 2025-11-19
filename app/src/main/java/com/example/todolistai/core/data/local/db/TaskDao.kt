package com.example.todolistai.core.data.local.db

import androidx.room.*
import com.example.todolistai.core.data.local.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks ORDER BY dueDate DESC")
    fun getAllTasks(): Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("SELECT * FROM tasks WHERE dueDate BETWEEN :startTime AND :endTime")
    fun getTasksForDateRange(startTime: Long, endTime: Long): Flow<List<Task>>
}
