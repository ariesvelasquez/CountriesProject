package com.example.countrylistexam.country.data.gateway

import com.example.countrylistexam.common.domain.model.Result
import com.example.countrylistexam.common.data.provider.ResponseProvider
import com.example.countrylistexam.country.data.mapper.Mapper.map
import com.example.countrylistexam.country.data.model.GetAllCountryDto
import com.example.countrylistexam.country.data.source.remote.CountryRemote
import com.example.countrylistexam.country.domain.gateway.CountryGateway
import com.example.countrylistexam.country.domain.model.Country
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountryGatewayImpl
@Inject
constructor(
    private val countryRemote: CountryRemote,
    private val handler: ResponseProvider
) : CountryGateway {

    override suspend fun getCountryList(): Result<List<Country>> {
        return handler.execute(
            countryRemote.getCountries(),
            {
                it.map()
            },
            GetAllCountryDto()
        )
    }
}