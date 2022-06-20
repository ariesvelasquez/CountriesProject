package com.example.countrylistexam.country.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countrylistexam.core.common.presenter.viewmodel.BaseViewModel
import com.example.countrylistexam.core.common.presenter.viewmodel.event.Event
import com.example.countrylistexam.core.common.presenter.viewmodel.state.UiState
import com.example.countrylistexam.country.domain.interactor.GetAllCountries
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CountryViewModel
@Inject
constructor(
    private val getAllCountries: GetAllCountries
) : BaseViewModel() {

    fun testGetAll() {
        Timber.e("testGetAll")
        getAllCountries.execute(
            viewModelScope,
            onLaunch = { _uiState.value = Event(UiState.Loading) },
            onSuccess = {
                Timber.e("onSuccess")
            },
            onError = { _uiState.value = Event(UiState.Error(it)) },
            onComplete = { _uiState.value = Event(UiState.Completed) }
        )
    }
}