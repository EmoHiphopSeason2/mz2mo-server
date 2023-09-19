package com.mz2mo.domain.music.application.service

import com.mz2mo.domain.music.application.port.input.MusicHistoryQueryUseCase
import com.mz2mo.domain.music.application.port.input.MusicHistorySaveUseCase
import com.mz2mo.domain.music.application.port.output.persistence.MusicHistoryPersistenceOutport
import com.mz2mo.domain.music.domain.MusicHistory
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice
import org.springframework.stereotype.Service

@Service
class MusicHistoryServiceQuery(
    private val musicHistoryPersistenceOutport: MusicHistoryPersistenceOutport
) : MusicHistoryQueryUseCase, MusicHistorySaveUseCase {

    override fun queryRecentlyPlayedMusic(pageable: Pageable, userId: String): Slice<MusicHistory> {
        return musicHistoryPersistenceOutport.queryRecentlyPlayedMusic(pageable, userId)
    }

    override fun saveMusicHistory(musicId: String, userId: String) {
        musicHistoryPersistenceOutport.saveHistory(musicId, userId)
    }
}
