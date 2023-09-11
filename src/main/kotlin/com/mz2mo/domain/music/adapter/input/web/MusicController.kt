package com.mz2mo.domain.music.adapter.input.web

import com.mz2mo.domain.music.adapter.input.data.response.MusicQueryResponse
import com.mz2mo.domain.music.application.port.input.MusicPlayUseCase
import com.mz2mo.domain.music.application.port.input.MusicQueryUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/music")
class MusicController(
    private val musicQueryUseCase: MusicQueryUseCase,
    private val musicPlayUseCase: MusicPlayUseCase
) {
    @GetMapping("/{musicId}")
    fun queryMusic(@PathVariable musicId: String): MusicQueryResponse {
        val music = musicQueryUseCase.queryMusic(musicId)
        return MusicQueryResponse.toResponse(music)
    }

    @GetMapping("/popular")
    fun queryPopularMusic(): List<MusicQueryResponse> {
        val music = musicQueryUseCase.queryPopularMusic()
        return music.map { MusicQueryResponse.toResponse(it) }
    }

    @PostMapping("/play/{musicId}/users/{userId}")
    fun playMusic(@PathVariable musicId: String, @PathVariable userId: String) {
        musicPlayUseCase.playMusic(musicId, userId)
    }

    @GetMapping("/users/{userId}")
    fun queryMyMusic(@PathVariable userId: String): List<MusicQueryResponse> {
        val music = musicQueryUseCase.queryRecentlyPlayedMusic(userId)
        return music.map { MusicQueryResponse.toResponse(it) }
    }
}
