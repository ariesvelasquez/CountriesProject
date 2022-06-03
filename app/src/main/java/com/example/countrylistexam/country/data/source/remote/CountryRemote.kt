package com.example.countrylistexam.country.data.source.remote

import com.example.countrylistexam.country.data.model.GetAllCountryDto
import retrofit2.Response

interface CountryRemote {

    fun getCountries() : Response<GetAllCountryDto>
}