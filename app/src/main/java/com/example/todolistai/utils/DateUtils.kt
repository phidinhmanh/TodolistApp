package com.example.todolistai.utils

// File: DateUtils.kt

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.*
import java.time.format.DateTimeFormatter

object DateUtils {

    @RequiresApi(Build.VERSION_CODES.O)
    private val zoneId: ZoneId = ZoneId.systemDefault()

    /**
     * Trả về cặp (startMillis, endMillis) của tháng hiện tại
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun getCurrentMonthRange(): Pair<Long, Long> {
        val now = ZonedDateTime.now(zoneId)
        return getMonthRange(now.year, now.monthValue)
    }

    /**
     * Trả về cặp (startMillis, endMillis) của tháng TRƯỚC (dùng để gửi stats cuối tháng)
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun getPreviousMonthRange(): Pair<Long, Long> {
        val now = ZonedDateTime.now(zoneId)
        val previous = now.minusMonths(1)
        return getMonthRange(previous.year, previous.monthValue)
    }

    /**
     * Trả về cặp (startMillis, endMillis) của tháng bất kỳ
     * @param year ví dụ 2025
     * @param month 1..12
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun getMonthRange(year: Int, month: Int): Pair<Long, Long> {
        val startOfMonth = ZonedDateTime.of(year, month, 1, 0, 0, 0, 0, zoneId)
        val startOfNextMonth = startOfMonth.plusMonths(1)

        val startMillis = startOfMonth.toInstant().toEpochMilli()
        val endMillisExclusive = startOfNextMonth.toInstant().toEpochMilli()

        return Pair(startMillis, endMillisExclusive)
    }
    /**
     * Trả về cặp (startMillis, endMillis) từ chuỗi "2025-11"
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun getMonthRange(monthYear: String): Pair<Long, Long> {
        val (yearStr, monthStr) = monthYear.split("-")
        return getMonthRange(yearStr.toInt(), monthStr.toInt())
    }

    /**
     * Format Long → dd/MM/yyyy (dùng hiển thị trên UI)
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun formatDate(millis: Long): String {
        val date = Instant.ofEpochMilli(millis)
            .atZone(zoneId)
            .toLocalDate()
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    }

    /**
     * Format Long → "Tháng 11/2025" (đẹp cho tiêu đề thống kê)
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun formatMonthYear(millis: Long): String {
        val date = Instant.ofEpochMilli(millis).atZone(zoneId)
        return date.format(DateTimeFormatter.ofPattern("'Tháng' MM/yyyy"))
    }

    /**
     * Trả về key tháng hiện tại dạng "2025-11" – dùng để lưu SharedPreferences hoặc Room
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun getCurrentMonthKey(): String {
        val now = LocalDate.now(zoneId)
        return "${now.year}-${String.format("%02d", now.monthValue)}"
    }

    /**
     * Trả về key tháng trước dạng "2025-10"
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun getPreviousMonthKey(): String {
        val previous = LocalDate.now(zoneId).minusMonths(1)
        return "${previous.year}-${String.format("%02d", previous.monthValue)}"
    }
}
