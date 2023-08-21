package com.mz2mo.domain.vote

fun interface QueryVoteUseCase {
    fun getVotes(musicId: String): List<Vote>
}
