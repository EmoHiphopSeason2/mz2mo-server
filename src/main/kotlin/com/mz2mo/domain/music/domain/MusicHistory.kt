package com.mz2mo.domain.music.domain

import java.time.LocalDateTime

data class MusicHistory(
    val musicId: String,
    val userId: String,
    val createdAt: LocalDateTime
)
