package com.example.todolistai.features.focus.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FocusViewModel : ViewModel() {

    private val _timeInMillis = MutableStateFlow(25 * 60 * 1000L) // 25 minutes
    val timeInMillis: StateFlow<Long> = _timeInMillis

    private val _isRunning = MutableStateFlow(false)
    val isRunning: StateFlow<Boolean> = _isRunning

    private var countDownTimer: CountDownTimer? = null

    fun startTimer() {
        if (_isRunning.value) return

        _isRunning.value = true
        countDownTimer = object : CountDownTimer(_timeInMillis.value, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                _timeInMillis.value = millisUntilFinished
            }

            override fun onFinish() {
                _isRunning.value = false
                // Play sound or show notification
            }
        }.start()
    }

    fun pauseTimer() {
        countDownTimer?.cancel()
        _isRunning.value = false
    }

    override fun onCleared() {
        super.onCleared()
        countDownTimer?.cancel()
    }
}
