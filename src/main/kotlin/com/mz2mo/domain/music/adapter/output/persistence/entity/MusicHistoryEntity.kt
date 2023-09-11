package com.mz2mo.domain.music.adapter.output.persistence.entity

import com.mz2mo.domain.common.jpa.BaseTimeEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity(name = "tbl_music_history")
class MusicHistoryEntity(
    @Column(name = "music_id")
    var musicId: String,

    @Column(name = "user_id")
    var userId: String,

    @Id
    @Column(name = "music_history_id")
    var id: String = UUID.randomUUID().toString()
) : BaseTimeEntity()
