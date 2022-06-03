package com.example.countrylistexam.country.domain.gateway

import com.example.countrylistexam.common.domain.model.Result
import com.example.countrylistexam.country.domain.model.Country

interface CountryGateway {

    suspend fun getCountryList() : Result<List<Country>>
}