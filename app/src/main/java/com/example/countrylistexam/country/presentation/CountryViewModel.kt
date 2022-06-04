package com.example.countrylistexam.country.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countrylistexam.country.domain.interactor.GetAllCountries
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CountryViewModel
@Inject
constructor(
    private val getAllCountries: GetAllCountries
) : ViewModel() {

    fun testGetAll() {
        getAllCountries.execute(
            viewModelScope,
            onLaunch = {
                Timber.e("onLaunch")
            },
            onSuccess = {
                Timber.e("onSuccess")
            },
            onError = {
                Timber.e("onError $it")
            },
            onComplete = {
                Timber.e("onComplete")
            }
        )
    }
}