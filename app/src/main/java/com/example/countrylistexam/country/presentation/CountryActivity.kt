package com.example.countrylistexam.country.presentation

import android.view.LayoutInflater
import androidx.activity.viewModels
import com.example.countrylistexam.core.common.presenter.activity.BaseActivity
import com.example.countrylistexam.core.common.presenter.viewmodel.event.EventObserver
import com.example.countrylistexam.core.common.presenter.viewmodel.state.UiState
import com.example.countrylistexam.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class CountryActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: CountryViewModel by viewModels()

    override fun initDataObservables() {
        super.initDataObservables()
        viewModel.testGetAll()
        viewModel.uiState.observe(this, EventObserver{
            when (it) {
                UiState.Completed -> dismissProgressDialog()
                is UiState.Error -> handleOnError(it.throwable)
                UiState.Loading -> showProgressDialog(this.javaClass.name)
            }
        })
    }


    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate
}