package com.mz2mo.domain.music.adapter.output.persistence.repository

import com.mz2mo.domain.music.adapter.output.persistence.entity.MusicEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MusicRepository : JpaRepository<MusicEntity, String>
