package com.mz2mo.domain.music.adapter.output.persistence.entity

import com.mz2mo.domain.common.jpa.BaseTimeEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.UUID

@Entity(name = "tbl_music")
class MusicEntity(
    val title: String,

    val artist: String,

    val musicKey: String,

    val thumbnail: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "music_id")
    var id: String = UUID.randomUUID().toString()
) : BaseTimeEntity()
