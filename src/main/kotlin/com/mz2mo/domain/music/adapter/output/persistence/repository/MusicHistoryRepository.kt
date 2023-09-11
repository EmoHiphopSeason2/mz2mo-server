package com.mz2mo.domain.music.adapter.output.persistence.repository

import com.mz2mo.domain.music.adapter.output.persistence.entity.MusicHistoryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MusicHistoryRepository : JpaRepository<MusicHistoryEntity, String> {
    fun findAllByUserId(userId: String): List<MusicHistoryEntity>
}
