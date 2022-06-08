package com.example.countrylistexam.country.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.example.countrylistexam.R
import com.example.countrylistexam.core.common.presenter.activity.BaseActivity
import com.example.countrylistexam.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

class CountryActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: CountryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.testGetAll()
    }

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate
}