package com.aeu.boxapplication.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<State, Event> : ViewModel() {

    abstract fun createInitialState(): State

    private val _state = MutableStateFlow(createInitialState())
    val state: StateFlow<State> = _state

    protected val currentState: State
        get() = _state.value

    protected fun setState(reducer: State.() -> State) {
        _state.value = currentState.reducer()
    }

    abstract fun handleEvent(event: Event)

    protected fun launch(block: suspend () -> Unit) {
        viewModelScope.launch {
            try {
                block()
            } catch (e: Exception) {
                handleException(e)
            }
        }
    }

    protected open fun handleException(exception: Exception) {
        exception.printStackTrace()
    }
}
