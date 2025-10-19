package com.posialero.echojournal.echos.presentation.echos

import com.posialero.echojournal.echos.presentation.echos.models.EchoFilterChip
import com.posialero.echojournal.echos.presentation.echos.models.TrackSizeInfo
import com.posialero.echojournal.echos.presentation.models.MoodUi

sealed interface EchosAction {
    data object OnMoodChipClick: EchosAction
    data object OnTopicChipClick: EchosAction

    data object OnDismissMoodDropDown: EchosAction
    data object OnDismissTopicDropDown: EchosAction

    data object OnFabClick: EchosAction
    data object OnFabLongClick: EchosAction
    data object OnSettingsClick: EchosAction
    data class OnRemoveFilters(val filterType: EchoFilterChip): EchosAction
    data class OnFilterByMoodClick(val moodUi: MoodUi): EchosAction
    data class OnFilerByTopicClick(val topic: String): EchosAction
    data class OnPlayEchoClick(val echoId: Int): EchosAction
    data object OnPauseClick: EchosAction
    data class OnTrackSizeAvailable(val trackSizeInfo: TrackSizeInfo): EchosAction
}
