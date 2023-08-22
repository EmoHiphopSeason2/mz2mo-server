package com.mz2mo.domain.music.adapter.input.data.response

import com.mz2mo.domain.music.domain.Music

data class MusicQueryResponse(
    val musicId: String,
    val title: String,
    val artist: String,
    val musicKey: String,
    val thumbnail: String
) {
    companion object {
        fun toResponse(music: Music): MusicQueryResponse {
            return MusicQueryResponse(
                musicId = music.musicId,
                title = music.title,
                artist = music.artist,
                musicKey = music.musicKey,
                thumbnail = music.thumbnail
            )
        }
    }
}
