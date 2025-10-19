package com.posialero.echojournal.echos.presentation.components

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.posialero.echojournal.core.presentation.designsystem.theme.EchoJournalTheme
import com.posialero.echojournal.core.presentation.designsystem.theme.MoodPrimary25
import com.posialero.echojournal.core.presentation.designsystem.theme.MoodPrimary35
import com.posialero.echojournal.core.presentation.designsystem.theme.MoodPrimary80
import com.posialero.echojournal.core.presentation.util.formatMMSS
import com.posialero.echojournal.echos.presentation.models.MoodUi
import com.posialero.echojournal.echos.presentation.models.PlaybackState
import kotlin.random.Random
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

@Composable
fun EchoMoodPlayer(
    moodUi: MoodUi?,
    playbackState: PlaybackState,
    playerProgress: () -> Float,
    durationPlayed: Duration,
    totalPlaybackDuration: Duration,
    powerRatios: List<Float>,
    onPlayClick: () -> Unit,
    onPauseClick: () -> Unit,
    amplitudeBarWidth: Dp = 5.dp,
    amplitudeBarSpacing: Dp = 4.dp,
    modifier: Modifier = Modifier
) {
    val iconTint = when (moodUi) {
        null -> MoodPrimary80
        else -> moodUi.colorSet.vivid
    }

    val trackFillColor = when (moodUi) {
        null -> MoodPrimary80
        else -> moodUi.colorSet.vivid
    }

    val backgroundColor = when (moodUi) {
        null -> MoodPrimary25
        else -> moodUi.colorSet.faded
    }

    val formattedDurationText = remember(durationPlayed, totalPlaybackDuration) {
        "${durationPlayed.formatMMSS()}/${totalPlaybackDuration.formatMMSS()}"
    }

    val trackColor = when (moodUi) {
        null -> MoodPrimary35
        else -> moodUi.colorSet.desaturated
    }

    Surface(
        shape = CircleShape,
        color = backgroundColor,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            EchoPlaybackButton(
                playbackState = playbackState,
                onPauseClick = onPauseClick,
                onPlayClick = onPlayClick,
                colors = IconButtonDefaults.filledIconButtonColors(
                    contentColor = iconTint,
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )

            EchoPlayBar(
                amplitudeBarSpacing = amplitudeBarSpacing,
                amplitudeBarWidth = amplitudeBarWidth,
                playerProgress = playerProgress,
                powerRatios = powerRatios,
                trackFillColor = trackFillColor,
                trackColor = trackColor,
                modifier = Modifier
                    .weight(1f)
                    .padding(
                        vertical = 10.dp,
                        horizontal = 8.dp
                    )
                    .fillMaxHeight()
            )

            Text(
                text = formattedDurationText,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .padding(end = 8.dp)
            )
        }
    }
}

@Preview
@Composable
private fun EchoMoodPlayerPreview() {
    EchoJournalTheme {
        val ratios = remember {
            (1..30).map { Random.nextFloat() }
        }

        EchoMoodPlayer(
            moodUi = MoodUi.STRESSED,
            playerProgress = { 0.3f },
            playbackState = PlaybackState.PAUSED,
            durationPlayed = 125.seconds,
            totalPlaybackDuration = 250.seconds,
            powerRatios = ratios,
            onPauseClick = {},
            onPlayClick = {},
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}