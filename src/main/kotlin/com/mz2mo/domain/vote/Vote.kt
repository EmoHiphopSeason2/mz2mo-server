package com.mz2mo.domain.vote

data class Vote(
    val id: String,
    val emoji: Emoji,
    val userId: String,
    val musicId: String
) {
    fun updateVote(emoji: Emoji): Vote {
        return this.copy(emoji = emoji)
    }
}
