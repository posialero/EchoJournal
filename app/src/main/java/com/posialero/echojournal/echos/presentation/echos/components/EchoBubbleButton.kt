package com.posialero.echojournal.echos.presentation.echos.components

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.posialero.echojournal.core.presentation.designsystem.theme.EchoJournalTheme
import com.posialero.echojournal.echos.presentation.echos.models.BubbleFloatingActionButtonColors
import com.posialero.echojournal.echos.presentation.echos.models.rememberBubbleFloatingActionButtonColors

@Composable
fun EchoBubbleButton(
    showBubble: Boolean,
    onClick: () -> Unit,
    primaryButtonSize: Dp = 56.dp,
    colors: BubbleFloatingActionButtonColors = rememberBubbleFloatingActionButtonColors(),
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }

    val isPressed by interactionSource.collectIsPressedAsState()
    Box(
        modifier = modifier
            .background(
                brush = if (showBubble) {
                    colors.outerCircle
                } else {
                    SolidColor(Color.Transparent)
                },
                shape = CircleShape
            )
            .padding(10.dp)
            .background(
                brush = if (showBubble) {
                    colors.innerCircle
                } else {
                    SolidColor(Color.Transparent)
                },
                shape = CircleShape
            )
            .padding(16.dp)
            .background(
                brush = if (isPressed) {
                    colors.primaryPressed
                } else {
                    colors.primary
                },
                shape = CircleShape
            )
            .size(primaryButtonSize)
            .clip(CircleShape)
            .clickable(
                interactionSource = interactionSource,
                indication = LocalIndication.current,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        icon()
    }
}

@Preview
@Composable
private fun EchoBubbleButtonPreview() {
    EchoJournalTheme {

    }

}