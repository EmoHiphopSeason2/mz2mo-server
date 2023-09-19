package com.mz2mo.domain.music.adapter.input.web

import com.mz2mo.domain.common.data.SliceResponse
import com.mz2mo.domain.music.adapter.input.data.response.MusicHistoryResponse
import com.mz2mo.domain.music.adapter.input.data.response.MusicQueryResponse
import com.mz2mo.domain.music.application.port.input.MusicHistoryQueryUseCase
import com.mz2mo.domain.music.application.port.input.MusicHistorySaveUseCase
import com.mz2mo.domain.music.application.port.input.MusicQueryUseCase
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/music")
class MusicController(
    private val musicQueryUseCase: MusicQueryUseCase,
    private val musicHistoryQueryUseCase: MusicHistoryQueryUseCase,
    private val musicHistorySaveUseCase: MusicHistorySaveUseCase
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

    @PostMapping("/{musicId}/listeners")
    fun playMusic(@PathVariable musicId: String, @RequestParam userId: String) {
        musicHistorySaveUseCase.saveMusicHistory(musicId, userId)
    }

    @GetMapping("/recent")
    fun queryRecentMusic(
        @PageableDefault pageable: Pageable,
        @RequestParam userId: String
    ): SliceResponse<MusicHistoryResponse> {
        val musicHistorySlice = musicHistoryQueryUseCase.queryRecentlyPlayedMusic(pageable, userId)
        return SliceResponse.of(musicHistorySlice.map { MusicHistoryResponse.toResponse(it) })
    }
}
