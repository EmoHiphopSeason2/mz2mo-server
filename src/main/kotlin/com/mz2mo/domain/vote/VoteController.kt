package com.mz2mo.domain.vote

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/votes")
class VoteController(
    private val voteService: VoteService
) {
    @PostMapping
    fun vote(@RequestBody createVote: CreateVote): Vote {
        return voteService.vote(createVote)
    }

    @GetMapping("/by-music/{musicId}")
    fun getVotes(
        @PathVariable("musicId") musicId: String
    ): List<Vote> {
        return voteService.getVotes(musicId)
    }
}
