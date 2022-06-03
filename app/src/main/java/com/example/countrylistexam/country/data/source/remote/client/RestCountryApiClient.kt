package com.example.countrylistexam.country.data.source.remote.client

import com.example.countrylistexam.country.data.model.GetAllCountryDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RestCountryApiClient {

    @GET("{api_version}/all")
    fun getAll(
        @Path("api_version")
        apiVersion: String
    ) : Response<GetAllCountryDto>
}