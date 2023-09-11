package com.mz2mo.domain.vote

import org.springframework.stereotype.Service
import java.util.UUID

@Service
class VoteService : QueryVoteUseCase, VoteUseCase {

    private val votes = mutableListOf<Vote>()

    override fun getVotes(musicId: String): List<Vote> =
        votes.filter { it.musicId == musicId }

    override fun getPopularVotes(): List<Vote> {
        // 각 음악별 투표 수를 계산
        val voteCounts = votes.groupingBy { it.musicId }
            .eachCount()

        // 투표 수가 가장 많은 음악을 내림차순으로 정렬
        val sortedVotes = voteCounts.entries.sortedByDescending { it.value }

        // 상위 10개 결과를 반환
        return sortedVotes.take(10).map { entry ->
            votes.first { it.musicId == entry.key }
        }
    }

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
