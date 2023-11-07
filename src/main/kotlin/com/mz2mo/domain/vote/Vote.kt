package com.mz2mo.domain.vote

data class Vote(
    val id: String,
    val emojiUnicode: String,
    val userId: String,
    val musicId: String
) {
    fun updateVote(emojiUnicode: String): Vote {
        return this.copy(emojiUnicode = emojiUnicode)
    }
}
