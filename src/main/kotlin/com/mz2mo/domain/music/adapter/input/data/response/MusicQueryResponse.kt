package com.mz2mo.domain.music.adapter.input.data.response

data class MusicQueryResponse(
    val musicId: String,
    val title: String,
    val artist: String,
    val key: String,
    val thumbnail: String
)