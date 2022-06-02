package com.example.countrylistexam.country.data

import com.google.gson.annotations.SerializedName

data class ApiError (
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("code")
    val code: Int? = null
)