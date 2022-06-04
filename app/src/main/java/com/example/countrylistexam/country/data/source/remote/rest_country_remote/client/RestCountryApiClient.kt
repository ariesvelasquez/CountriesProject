package com.example.countrylistexam.country.data.source.remote.rest_country_remote.client

import com.example.countrylistexam.country.data.model.CountryDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RestCountryApiClient {

    @GET("{api_version}/all")
    suspend fun getAll(
        @Path("api_version")
        apiVersion: String
    ) : Response<List<CountryDto>>
}