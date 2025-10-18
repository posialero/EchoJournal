package com.posialero.echojournal.echos.presentation.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

enum class MoodUi {
}

data class MoodIconSet(
    @DrawableRes val fillId: Int,
    @DrawableRes val outlineId: Int
)

data class MoodColorSet(
    val vivid: Color,
    val desaturated: Color,
    val faded: Color
)