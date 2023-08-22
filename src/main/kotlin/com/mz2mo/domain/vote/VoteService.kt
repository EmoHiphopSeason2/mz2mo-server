package com.mz2mo.domain.vote

import org.springframework.stereotype.Service
import java.util.UUID

@Service
class VoteService : QueryVoteUseCase, VoteUseCase {
    private val votes = mutableListOf<Vote>()

    override fun getVotes(musicId: String): List<Vote> =
        votes.filter { it.musicId == musicId }

    override fun vote(createVote: CreateVote): Vote {
        val vote = Vote(
            id = UUID.randomUUID().toString(),
            emojiId = createVote.emojiId,
            userId = createVote.userId,
            musicId = createVote.musicId
        )
        votes.add(vote)
        return vote
    }
}
