package com.example.countrylistexam.country.domain.gateway

import com.example.countrylistexam.country.domain.model.Country
import retrofit2.Response

interface CountryGateway {

    suspend fun getCountryList() : Response<List<Country>>
}