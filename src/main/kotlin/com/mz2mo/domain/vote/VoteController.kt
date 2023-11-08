package com.mz2mo.domain.vote

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/votes")
class VoteController(
    private val voteService: VoteService
) {
    @PostMapping
    fun vote(
        @RequestBody createVote: CreateVote,
        @RequestParam unicode: String
    ): Vote {
        val emoji = Emoji.fromUnicode(unicode)
        return voteService.vote(createVote, emoji)
    }

    @PutMapping
    fun updateVote(
        @RequestBody updateVote: UpdateVote,
        @RequestParam unicode: String
    ): Vote {
        val emoji = Emoji.fromUnicode(unicode)
        return voteService.updateVote(updateVote, emoji)
    }

    @GetMapping("/by-music/{musicId}")
    fun getVotes(
        @PathVariable("musicId") musicId: String
    ): List<Vote> {
        return voteService.getVotes(musicId)
    }
}
