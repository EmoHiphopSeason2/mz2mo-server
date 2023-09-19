package com.mz2mo.domain.music.adapter.output.persistence

import com.mz2mo.domain.music.adapter.output.persistence.entity.MusicHistoryEntity
import com.mz2mo.domain.music.adapter.output.persistence.repository.MusicHistoryRepository
import com.mz2mo.domain.music.application.port.output.persistence.MusicHistoryPersistenceOutport
import com.mz2mo.domain.music.domain.MusicHistory
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice
import org.springframework.stereotype.Service

@Service
class JpaMusicHistoryPersistenceOutAdapter(
    val musicHistoryRepository: MusicHistoryRepository
) : MusicHistoryPersistenceOutport {
    override fun saveHistory(musicId: String, userId: String) {
        musicHistoryRepository.save(
            MusicHistoryEntity(
                musicId = musicId,
                userId = userId
            )
        )
    }

    override fun queryRecentlyPlayedMusic(pageable: Pageable, userId: String): Slice<MusicHistory> {
        return musicHistoryRepository.findAllByUserIdOrderByCreatedAtDesc(pageable, userId)
            .map { MusicHistory(it.musicId, it.userId, it.createdAt) }
    }
}
