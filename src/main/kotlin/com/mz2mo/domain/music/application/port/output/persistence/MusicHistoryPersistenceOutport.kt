package com.mz2mo.domain.music.application.port.output.persistence

import com.mz2mo.domain.music.domain.MusicHistory
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice

interface MusicHistoryPersistenceOutport {
    fun saveHistory(musicId: String, userId: String)
    fun queryRecentlyPlayedMusic(pageable: Pageable, userId: String): Slice<MusicHistory>
}
