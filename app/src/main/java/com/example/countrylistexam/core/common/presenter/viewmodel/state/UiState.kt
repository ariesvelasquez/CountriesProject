package com.example.countrylistexam.core.common.presenter.viewmodel.state

sealed class UiState {
    object Success: UiState()
    object Loading: UiState()
    object Completed: UiState()
    data class Error(val throwable: Throwable): UiState()
}