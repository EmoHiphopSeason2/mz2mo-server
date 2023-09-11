package com.mz2mo.domain.music.application.port.output.persistence

import com.mz2mo.domain.music.adapter.output.persistence.entity.MusicHistoryEntity

interface MusicHistoryPersistenceOutport {
    fun saveHistory(musicId: String, userId: String)
    fun queryRecentlyPlayedMusic(userId: String): List<MusicHistoryEntity>
}
