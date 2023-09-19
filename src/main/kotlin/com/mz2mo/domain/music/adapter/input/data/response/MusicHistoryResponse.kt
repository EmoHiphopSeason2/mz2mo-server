package com.mz2mo.domain.music.adapter.input.data.response

import com.mz2mo.domain.music.domain.MusicHistory
import java.time.LocalDateTime

data class MusicHistoryResponse(
    val musicId: String,
    val userId: String,
    val createdAt: LocalDateTime
) {
    companion object {
        fun toResponse(musicHistory: MusicHistory): MusicHistoryResponse {
            return MusicHistoryResponse(
                musicId = musicHistory.musicId,
                userId = musicHistory.userId,
                createdAt = musicHistory.createdAt
            )
        }
    }
}
