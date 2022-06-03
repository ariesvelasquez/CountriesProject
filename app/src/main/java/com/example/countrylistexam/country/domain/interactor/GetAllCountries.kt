package com.example.countrylistexam.country.domain.interactor

import com.example.countrylistexam.common.domain.interactor.BaseUseCase
import com.example.countrylistexam.common.domain.model.Result
import com.example.countrylistexam.country.domain.gateway.CountryGateway
import com.example.countrylistexam.country.domain.model.Country
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAllCountries
@Inject
constructor(
    private val countryGateway: CountryGateway
) : BaseUseCase<List<Country>, Any>() {

    override suspend fun run(params: Any?): Result<List<Country>> {
        return countryGateway.getCountryList()
    }
}