package com.mz2mo.domain.music.adapter.output.persistence.entity

import com.mz2mo.domain.common.jpa.BaseTimeEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "tbl_music")
class MusicEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val postId: Long? = null,

    val title: String,

    val artist: String,

    val key: String,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "music_id")
    val id: Long? = null
) : BaseTimeEntity()
