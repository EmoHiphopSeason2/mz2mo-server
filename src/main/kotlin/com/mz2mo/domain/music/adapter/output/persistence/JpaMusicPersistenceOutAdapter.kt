package com.mz2mo.domain.music.adapter.output.persistence

import com.mz2mo.domain.music.adapter.output.persistence.repository.MusicRepository
import com.mz2mo.domain.music.application.port.output.persistence.MusicPersistenceOutport
import com.mz2mo.domain.music.domain.Music
import org.springframework.stereotype.Service

@Service
class JpaMusicPersistenceOutAdapter(
    val musicRepository: MusicRepository
) : MusicPersistenceOutport {
    override fun queryMusic(musicId: String): Music {
        musicRepository.findById(musicId).orElseThrow {
            IllegalArgumentException("Music not found")
        }.let {
            return Music(
                it.id,
                it.title,
                it.artist,
                it.musicKey,
                it.thumbnail
            )
        }
    }
}
