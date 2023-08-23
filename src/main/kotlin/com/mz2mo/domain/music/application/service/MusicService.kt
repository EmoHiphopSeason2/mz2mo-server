package com.mz2mo.domain.music.application.service

import com.mz2mo.domain.music.application.port.input.MusicQueryUseCase
import com.mz2mo.domain.music.application.port.output.persistence.MusicPersistenceOutport
import com.mz2mo.domain.music.domain.Music
import org.springframework.stereotype.Service

@Service
class MusicService(
    private val musicPersistenceOutport: MusicPersistenceOutport
) : MusicQueryUseCase {
    override fun queryMusic(musicId: String): Music {
        return musicPersistenceOutport.queryMusic(musicId)
    }
}
