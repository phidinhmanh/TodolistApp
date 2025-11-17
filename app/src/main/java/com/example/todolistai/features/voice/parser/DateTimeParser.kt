package com.example.todolistai.features.voice.parser

import java.util.Calendar

object DateTimeParser {
    fun parse(text: String): Long? {
        val calendar = Calendar.getInstance()
        // This is a very basic implementation. A more robust solution would use a proper NLP library.
        if (text.contains("ngày mai")) {
            calendar.add(Calendar.DAY_OF_YEAR, 1)
            return calendar.timeInMillis
        } else if (text.matches(Regex(".*(\d+).giờ.*"))) {
            val hour = Regex(".*(\d+).giờ.*").find(text)!!.groupValues[1].toInt()
            calendar.set(Calendar.HOUR_OF_DAY, hour)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            return calendar.timeInMillis
        }
        return null
    }
}
