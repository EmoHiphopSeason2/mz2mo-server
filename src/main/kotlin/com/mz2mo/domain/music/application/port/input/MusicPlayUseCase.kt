package com.mz2mo.domain.music.application.port.input

interface MusicPlayUseCase {
    fun playMusic(musicId: String, userId: String)
}
