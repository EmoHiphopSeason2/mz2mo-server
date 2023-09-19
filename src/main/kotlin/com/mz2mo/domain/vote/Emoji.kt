package com.mz2mo.domain.vote

import com.fasterxml.jackson.annotation.JsonFormat

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
enum class Emoji(val unicode: String) {
    GRIN("U+1F601"),
    STUCK_OUT_TONGUE_WINKING_EYE("U+1F61C"),
    RAGE("U+1F621"),
    SOB("U+1F62D"),
    SCREAM("U+1F631"),
    PARY("U+1F64F"),
    SPARKLES("U+2728"),
    COFFEE("U+2615"),
    SNOWMAN("U+26C4"),
    RAINBOW("U+1F308"),
    OCEAN("U+1F30A"),
    FOUR_LEAF_CLOVER("U+1F340"),
    LOLLIPOP("U+1F36D"),
    JACK_O_LANTERN("U+1F383"),
    TADA("U+1F389"),
    MORTAR_BOARD("U+1F393"),
    PERSON_RUNNING("U+1F3C3"),
    PILL("U+1F48A"),
    RING("U+1F48D"),
    TOW_HEARTS("U+1F495"),
    MONEY_BAG("U+1F4B0"),
    MUSLCE("U+1F4AA"),
    FIRE("U+1F525"),
    SUNGLASSES("U+1F60E"),
    SMILING_IMP("U+1F608"),
    SLEEPING("U+1F634"),
    BATHTUB("U+1F6C1"),
    SNAIL("U+1F40C"),
    MICROPONE("U+1F3A4"),
    SWEET_DROPS("U+1F4A6") ;

    companion object {
        fun getEmojiByUnicode(unicode: String): Emoji {
            return Emoji.values().find { it.unicode == unicode }
                ?: throw IllegalArgumentException("Invalid Unicode: $unicode")
        }
    }
}
