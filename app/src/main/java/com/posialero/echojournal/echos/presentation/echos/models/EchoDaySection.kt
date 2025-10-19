package com.posialero.echojournal.echos.presentation.echos.models

import com.posialero.echojournal.core.presentation.util.UiText
import com.posialero.echojournal.echos.presentation.models.EchoUi

data class EchoDaySection(
    val dateHeader: UiText,
    val echos: List<EchoUi>
)
