package com.mz2mo.domain.vote

import org.springframework.stereotype.Service
import java.util.*

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

    override fun vote(createVote: CreateVote, emoji: Emoji): Vote {
        val vote = Vote(
            id = UUID.randomUUID().toString(),
            emojiUnicode = emoji.unicode,
            userId = createVote.userId,
            musicId = createVote.musicId
        )
        votes.add(vote)
        return vote
    }

    override fun updateVote(updateVote: UpdateVote, emoji: Emoji): Vote {
        val vote = votes.find { it.userId == updateVote.userId && it.musicId == updateVote.musicId }
            ?: throw NoSuchElementException(
                "Vote not found with userId: ${updateVote.userId} and musicId: ${updateVote.musicId}"
            )

        val updatedVote = vote.updateVote(emoji.unicode)

        // votes 리스트에서 기존 투표를 삭제하고 업데이트된 투표를 추가합니다.
        // TODO: Repository 생성 후 로직 변경
        votes.apply {
            remove(vote)
            add(updatedVote)
        }

        return updatedVote
    }
}
