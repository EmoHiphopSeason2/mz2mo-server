package com.mz2mo.domain.vote

fun interface VoteUseCase {
    fun vote(createVote: CreateVote, emoji: Emoji): Vote
    fun updateVote(updateVote: UpdateVote, emoji: Emoji): Vote
}
