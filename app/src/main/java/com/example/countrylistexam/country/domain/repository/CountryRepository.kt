package com.example.countrylistexam.country.domain.repository

import com.example.countrylistexam.core.common.domain.model.Result
import com.example.countrylistexam.country.domain.model.Country

interface CountryRepository {

    suspend fun getCountryList() : Result<List<Country>>
}