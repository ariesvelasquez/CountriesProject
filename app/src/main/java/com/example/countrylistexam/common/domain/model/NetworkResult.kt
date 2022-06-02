package com.example.countrylistexam.common.domain.model

sealed class NetworkResult<T> {
    class Success<T>(val data: T) : NetworkResult<T>()
    class Error<T>(val e: Throwable) : NetworkResult<T>()
}