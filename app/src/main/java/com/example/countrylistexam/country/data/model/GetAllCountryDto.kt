package com.example.countrylistexam.country.data.model

import com.google.gson.annotations.SerializedName

class GetAllCountryDto {
    @SerializedName("country_list")
    val countries: List<CountryDto>? = null
}