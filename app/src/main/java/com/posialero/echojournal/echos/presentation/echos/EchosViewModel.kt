package com.posialero.echojournal.echos.presentation.echos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class EchosViewModel : ViewModel() {

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(EchosState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                /** Load initial data here **/
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = EchosState()
        )

    fun onAction(action: EchosAction) {
        when (action) {
            EchosAction.OnFabClick -> {}
            EchosAction.OnFabLongClick -> TODO()
            EchosAction.OnMoodChipClick -> TODO()
            is EchosAction.OnRemoveFilters -> TODO()
            EchosAction.OnTopicChipClick -> TODO()
            EchosAction.OnSettingsClick -> TODO()
        }
    }

}