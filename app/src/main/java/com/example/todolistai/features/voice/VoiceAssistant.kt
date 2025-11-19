package com.example.todolistai.features.voice

import kotlinx.coroutines.flow.StateFlow
import com.example.todolistai.core.data.local.model.Task



// features/voice/VoiceAssistant.kt
interface VoiceAssistant {
    /**
     * Bắt đầu nghe giọng nói
     * @param onResult: khi có kết quả cuối cùng (sau khi parse) → trả về Task đã sẵn sàng tạo
     * @param onError: lỗi (mic bị chiếm, không quyền, v.v.)
     * @param onPartialResult: optional – text realtime để hiện sóng âm
     */
    fun startListening(
        onResult: (Task) -> Unit,
        onError: (String) -> Unit,
        onPartialResult: ((String) -> Unit)? = null
    )

    /** Dừng nghe ngay lập tức */
    fun stopListening()

    /** Kiểm tra đang nghe hay không */
    val isListening: StateFlow<Boolean>

    /** Giải phóng tài nguyên khi không dùng nữa (gọi trong ViewModel.clear hoặc Activity.destroy) */
    fun release()
}