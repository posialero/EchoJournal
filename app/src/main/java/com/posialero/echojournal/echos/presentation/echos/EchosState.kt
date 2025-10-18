package com.posialero.echojournal.echos.presentation.echos

import com.posialero.echojournal.R
import com.posialero.echojournal.core.presentation.designsystem.dropdowns.Selectable
import com.posialero.echojournal.core.presentation.designsystem.dropdowns.Selectable.Companion.asUnselectedItems
import com.posialero.echojournal.core.presentation.util.UiText
import com.posialero.echojournal.echos.presentation.echos.models.EchoFilterChip
import com.posialero.echojournal.echos.presentation.echos.models.MoodChipContent
import com.posialero.echojournal.echos.presentation.models.MoodUi

data class EchosState(
    val hasEchosRecorded: Boolean = false,
    val hasActiveTopicFilters: Boolean = false,
    val hasActiveMoodFilters: Boolean = false,
    val isLoadingData: Boolean = false,
    val moods: List<Selectable<MoodUi>> = MoodUi.entries.asUnselectedItems(),
    val topics: List<Selectable<String>> = listOf("Love", "Happy", "Work").asUnselectedItems(),
    val moodChipContent: MoodChipContent = MoodChipContent(),
    val selectedEchoFilterChip: EchoFilterChip? = null,
    val topicChipTitle: UiText = UiText.StringResource(R.string.all_topics),
)
