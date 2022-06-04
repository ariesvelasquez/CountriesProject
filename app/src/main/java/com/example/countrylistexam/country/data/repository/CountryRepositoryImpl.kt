package com.example.countrylistexam.country.data.repository

import com.example.countrylistexam.core.common.domain.model.Result
import com.example.countrylistexam.country.data.mapper.Mapper.transform
import com.example.countrylistexam.country.data.source.remote.rest_country_remote.provider.RestCountryResponseProvider
import com.example.countrylistexam.country.data.source.remote.CountryRemote
import com.example.countrylistexam.country.data.source.remote.rest_country_remote.impl.RestCountryRemoteImpl
import com.example.countrylistexam.country.domain.repository.CountryRepository
import com.example.countrylistexam.country.domain.model.Country
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountryRepositoryImpl
@Inject
constructor(
    private val countryRemote: RestCountryRemoteImpl,
    private val handler: RestCountryResponseProvider
) : CountryRepository {

    override suspend fun getCountryList(): Result<List<Country>> {
        return handler.execute(
            countryRemote.getCountries(),
            { it.transform() },
            mutableListOf()
        )
    }
}