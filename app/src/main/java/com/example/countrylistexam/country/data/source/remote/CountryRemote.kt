package com.example.countrylistexam.country.data.source.remote

import com.example.countrylistexam.country.data.model.CountryDto
import retrofit2.Response

interface CountryRemote {

    suspend fun getCountries() : Response<List<CountryDto>>
}