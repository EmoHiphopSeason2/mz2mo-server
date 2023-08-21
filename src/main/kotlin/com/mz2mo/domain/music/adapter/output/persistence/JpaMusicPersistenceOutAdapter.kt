package com.mz2mo.domain.music.adapter.output.persistence

import com.linecorp.kotlinjdsl.QueryFactory
import com.linecorp.kotlinjdsl.querydsl.expression.column
import com.linecorp.kotlinjdsl.selectQuery
import com.mz2mo.domain.music.adapter.output.persistence.entity.MusicEntity
import com.mz2mo.domain.music.application.port.output.persistence.MusicPersistenceOutport
import com.mz2mo.domain.music.domain.Music
import jakarta.persistence.NoResultException
import org.springframework.stereotype.Service

@Service
class JpaMusicPersistenceOutAdapter(
    val queryFactory: QueryFactory
) : MusicPersistenceOutport {
    override fun queryMusic(musicId: Long): Music {
        val query = queryFactory.selectQuery<MusicEntity> {
            select(entity(MusicEntity::class))
            from(entity(MusicEntity::class))
            where(column(MusicEntity::id).equal(musicId))
        }
        val musicEntity = try {
            query.singleResult
        } catch (e: NoResultException) {
            throw IllegalArgumentException("Music not found")
        }
        return Music(
            musicEntity.id!!,
            musicEntity.title,
            musicEntity.artist,
            musicEntity.musicKey,
            musicEntity.thumbnail
        )
    }
}
