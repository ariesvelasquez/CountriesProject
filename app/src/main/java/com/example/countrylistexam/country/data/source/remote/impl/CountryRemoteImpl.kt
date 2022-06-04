package com.example.countrylistexam.country.data.source.remote.impl

import com.example.countrylistexam.BuildConfig
import com.example.countrylistexam.country.data.model.CountryDto
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

    override suspend fun getCountries(): Response<List<CountryDto>> {
        return apiClient.getAll(
            BuildConfig.REST_COUNTRY_API_VERSION
        )
    }
}