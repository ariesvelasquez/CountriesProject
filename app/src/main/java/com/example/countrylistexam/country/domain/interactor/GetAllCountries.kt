package com.example.countrylistexam.country.domain.interactor

import com.example.countrylistexam.core.common.domain.interactor.BaseUseCase
import com.example.countrylistexam.core.common.domain.model.Result
import com.example.countrylistexam.country.domain.repository.CountryRepository
import com.example.countrylistexam.country.domain.model.Country
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAllCountries
@Inject
constructor(
    private val repositoryModule: CountryRepository
) : BaseUseCase<List<Country>, Any>() {

    override suspend fun run(params: Any?): Result<List<Country>> {
        return repositoryModule.getCountryList()
    }
}