package com.mz2mo.domain.music.application.port.output.persistence

import com.mz2mo.domain.music.domain.Music

interface MusicPersistenceOutport {
    fun queryMusic(musicId: String): Music
}
