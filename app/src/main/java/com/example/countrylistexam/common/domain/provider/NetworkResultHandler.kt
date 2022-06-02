package com.example.countrylistexam.common.domain.provider

import android.net.Network
import com.example.countrylistexam.common.domain.model.NetworkResult
import retrofit2.Response

interface NetworkResultHandler {

    suspend fun <T> handlerResponse(response: Response<T>) : NetworkResult<T>

    suspend fun <T> handleOnError(response: Response<T>): NetworkResult<T>
}