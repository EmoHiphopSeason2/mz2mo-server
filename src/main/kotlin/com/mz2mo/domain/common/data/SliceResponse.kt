package com.mz2mo.domain.common.data

import org.springframework.data.domain.Slice

data class SliceResponse<T>(
    val content: List<T>,
    val page: Int,
    val size: Int,
    val hasNext: Boolean
) {
    companion object {
        fun <T> of(slice: Slice<T>): SliceResponse<T> {
            return SliceResponse(
                slice.content,
                slice.number,
                slice.numberOfElements,
                slice.hasNext()
            )
        }
    }
}
