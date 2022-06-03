package com.example.countrylistexam.country.data.source.remote.impl

import com.example.countrylistexam.BuildConfig
import com.example.countrylistexam.country.data.model.GetAllCountryDto
import com.example.countrylistexam.country.data.source.remote.CountryRemote
import com.example.countrylistexam.country.data.source.remote.client.RestCountryApiClient
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountryRemoteImpl
@Inject
constructor(
    retrofit: Retrofit
) : CountryRemote {

    private val apiClient: RestCountryApiClient =
        retrofit.create(RestCountryApiClient::class.java)

    override fun getCountries(): Response<GetAllCountryDto> {
        return apiClient.getAll(
            BuildConfig.VERSION_NAME
        )
    }
}