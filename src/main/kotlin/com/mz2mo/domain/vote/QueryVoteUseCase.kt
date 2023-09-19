package com.mz2mo.domain.vote

interface QueryVoteUseCase {
    fun getVotes(musicId: String): List<Vote>
    fun getPopularVotes(): List<Vote>
}
