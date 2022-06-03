package com.example.countrylistexam.common.data.provider

import com.example.countrylistexam.common.domain.model.Result
import retrofit2.Response

interface ResponseProvider {

    suspend fun <T, V> execute(
        response: Response<T>,
        transform: (T) -> V,
        default: T
    ) : Result<V>

    suspend fun <T, V> handleOnError(response: Response<T>): Result<V>
}