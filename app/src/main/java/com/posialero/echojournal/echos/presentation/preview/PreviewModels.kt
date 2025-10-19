package com.posialero.echojournal.echos.presentation.preview

import com.posialero.echojournal.echos.presentation.echos.models.PlaybackState
import com.posialero.echojournal.echos.presentation.models.EchoUi
import com.posialero.echojournal.echos.presentation.models.MoodUi
import java.time.Instant
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

data object PreviewModels {
    val echoUi = EchoUi(
        id = 1,
        title = "My audio memo",
        mood = MoodUi.EXCITED,
        recordedAt = Instant.now(),
        note = (1..50).joinToString(" ") { "Hello" },
        topics = listOf("Love", "Work"),
        amplitudes = (1..30).map { Random.nextFloat() },
        playbackTotalDuration = 250.seconds,
        playbackCurrentDuration = 125.seconds,
        playbackState = PlaybackState.PAUSED
    )
}
