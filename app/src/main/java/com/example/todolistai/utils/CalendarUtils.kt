package com.example.todolistai.utils

import java.util.Calendar

object CalendarUtils {
    fun isSameDay(date1: Long, date2: Long): Boolean {
        val cal1 = Calendar.getInstance()
        cal1.timeInMillis = date1
        val cal2 = Calendar.getInstance()
        cal2.timeInMillis = date2
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
               cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)
    }
}
