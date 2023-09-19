package com.mz2mo.domain.music.application.port.input

import com.mz2mo.domain.music.domain.MusicHistory
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice

interface MusicHistoryQueryUseCase {
    fun queryRecentlyPlayedMusic(pageable: Pageable, userId: String): Slice<MusicHistory>
}
