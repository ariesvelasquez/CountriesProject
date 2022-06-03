package com.example.countrylistexam.country.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countrylistexam.app.util.extension.JsonHelper
import com.example.countrylistexam.country.domain.interactor.GetAllCountries
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(
    getAllCountries: GetAllCountries
) : ViewModel() {

    init {
        getAllCountries.execute(
            viewModelScope,
            onSuccess = {
                Log.e("Test", JsonHelper.toJson(it))
            },
            onError = {
                Log.e("Test", it.message ?: "asdf")
            }
        )
    }
}