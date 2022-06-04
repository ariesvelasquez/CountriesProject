package com.example.countrylistexam.core.common.domain.model

sealed class Result<T> {
    class Success<T>(val data: T) : Result<T>()
    class Error<T>(val e: Throwable) : Result<T>()
}