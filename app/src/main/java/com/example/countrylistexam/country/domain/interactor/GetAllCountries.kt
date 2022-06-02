package com.example.countrylistexam.country.domain.interactor

import com.example.countrylistexam.common.domain.interactor.BaseUseCase
import com.example.countrylistexam.common.domain.model.NetworkResult
import com.example.countrylistexam.common.domain.provider.NetworkResultHandler
import com.example.countrylistexam.country.domain.gateway.CountryGateway
import com.example.countrylistexam.country.domain.model.Country
import javax.inject.Inject

class GetAllCountries
@Inject
constructor(
    private val networkResultHandler: NetworkResultHandler,
    private val countryGateway: CountryGateway
) : BaseUseCase<List<Country>, Any>() {

    override suspend fun run(params: Any?): NetworkResult<List<Country>> {
        return networkResultHandler
            .handlerResponse(countryGateway.getCountryList())
    }
}