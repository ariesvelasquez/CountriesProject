package com.example.countrylistexam.country.data.mapper

import com.example.countrylistexam.country.data.model.CountryDto
import com.example.countrylistexam.country.domain.model.Country

object Mapper {

    fun List<CountryDto>.transform() : List<Country> {
        return this.map {
            Country(
                status = it.status
            )
        }
    }
}