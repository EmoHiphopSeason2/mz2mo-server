package com.mz2mo.domain.music.adapter.output.persistence.repository

import com.mz2mo.domain.music.adapter.output.persistence.entity.MusicHistoryEntity
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice
import org.springframework.data.jpa.repository.JpaRepository

interface MusicHistoryRepository : JpaRepository<MusicHistoryEntity, String> {
    fun findAllByUserIdOrderByCreatedAtDesc(pageable: Pageable, userId: String): Slice<MusicHistoryEntity>
}
