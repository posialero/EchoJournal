package com.posialero.echojournal.echos.presentation.echos.models

import com.posialero.echojournal.R
import com.posialero.echojournal.core.presentation.util.UiText

data class MoodChipContent(
    val iconsRes: List<Int> = emptyList(),
    val title: UiText = UiText.StringResource(R.string.all_moods)
)