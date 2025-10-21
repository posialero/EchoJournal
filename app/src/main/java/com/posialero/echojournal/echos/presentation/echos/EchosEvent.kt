package com.posialero.echojournal.echos.presentation.echos

import com.posialero.echojournal.echos.domain.recording.RecordingDetails

interface EchosEvent {
    data object RequestAudioPermission: EchosEvent
    data object RecordingTooShort: EchosEvent
    data class OnDoneRecording(val recordingDetails: RecordingDetails): EchosEvent
}