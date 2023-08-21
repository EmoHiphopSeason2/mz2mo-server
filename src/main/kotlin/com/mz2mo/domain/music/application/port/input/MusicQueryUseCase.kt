package com.mz2mo.domain.music.application.port.input

import com.mz2mo.domain.music.domain.Music

interface MusicQueryUseCase {
    fun queryMusic(musicId: Long): Music
}
