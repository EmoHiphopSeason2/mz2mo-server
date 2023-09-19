package com.mz2mo.domain.music.application.port.input

interface MusicHistorySaveUseCase {
    fun saveMusicHistory(musicId: String, userId: String)
}
