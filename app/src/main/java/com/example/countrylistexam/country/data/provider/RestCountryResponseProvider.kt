package com.example.countrylistexam.country.data.provider

import android.content.Context
import com.example.countrylistexam.app.util.extension.JsonHelper
import com.example.countrylistexam.common.domain.exception.*
import com.example.countrylistexam.common.domain.exception.httpexception.*
import com.example.countrylistexam.common.domain.model.Result
import com.example.countrylistexam.common.data.provider.ResponseProvider
import com.example.countrylistexam.country.data.ApiError
import com.example.countrylistexam.country.domain.constant.ApiErrorEnum
import com.example.countrylistexam.country.domain.exception.SomeApiSpecificException
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RestCountryResponseProvider
@Inject
constructor(
    @ApplicationContext
    private val context: Context
) : ResponseProvider {

    override suspend fun <T, V> execute(
        response: Response<T>,
        transform: (T) -> V,
        default: T
    ): Result<V> {
        return try {
            val body = response.body()
            if (response.isSuccessful && body != null) {
                Result.Success(transform((response.body() ?: default)))
            } else {
                handleOnError(response)
            }
        } catch (e: Throwable) {
            throwException(e)
        }
    }

    override suspend fun <T, V> handleOnError(response: Response<T>): Result<V> {
        val errorResponse = response.errorBody()?.toString()
        return try {
            val apiError = JsonHelper.fromJson<ApiError>(errorResponse!!)
            val throwable = when (apiError.code) {
                ApiErrorEnum.MISSING_PARAM_VALIDATION.value -> SomeApiSpecificException(
                    context,
                    apiError.message
                )
                else -> UnknownErrorException(context, apiError.message)
            }
            return Result.Error(throwable)
        } catch (e: Throwable) {
            throwException(e)
        }
    }

    private fun <T> throwException(throwable: Throwable): Result.Error<T> {
        val exception = when (throwable) {
            is HttpException -> {
                when (throwable.code()) {
                    400 -> BadRequestException(context, throwable.message())
                    401 -> UnAuthorizedException(context, throwable.message())
                    403 -> ForbiddenException(context, throwable.message())
                    404 -> NotFoundException(context, throwable.message())
                    500 -> InternalServerError(context, throwable.message())
                    else -> UnknownErrorException(context, throwable.message())
                }
            }

            is SocketTimeoutException -> {
                SocketTimeoutException(throwable.message)
            }

            is IOException -> {
                IOException(throwable.message)
            }

            else -> SomethingWentWrongException(context, throwable.message)
        }
        return Result.Error(exception)
    }
}