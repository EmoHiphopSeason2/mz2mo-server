package com.mz2mo.domain.vote

fun interface VoteUseCase {
    fun vote(createVote: CreateVote): Vote
}