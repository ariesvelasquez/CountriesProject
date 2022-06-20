package com.example.countrylistexam.core.common.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countrylistexam.core.common.presenter.viewmodel.event.Event
import com.example.countrylistexam.core.common.presenter.viewmodel.state.UiState

abstract class BaseViewModel: ViewModel() {

    val _uiState = MutableLiveData<Event<UiState>>()

    val uiState: LiveData<Event<UiState>>
        get() = _uiState
}