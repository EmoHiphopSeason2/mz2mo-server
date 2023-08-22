package com.mz2mo.domain.music.adapter.input.web

import com.mz2mo.domain.music.adapter.input.data.response.MusicQueryResponse
import com.mz2mo.domain.music.application.port.input.MusicQueryUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/music")
class MusicController(
    private val musicUseCase: MusicQueryUseCase
) {
    @GetMapping("/{musicId}")
    fun queryMusic(@PathVariable musicId: String): MusicQueryResponse {
        val music = musicUseCase.queryMusic(musicId)
        return MusicQueryResponse.toResponse(music)
    }
}
