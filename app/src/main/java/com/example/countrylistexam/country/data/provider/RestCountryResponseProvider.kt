package com.example.countrylistexam.country.data.provider

import android.content.Context
import com.example.countrylistexam.core.common.domain.exception.httpexception.*
import com.example.countrylistexam.core.common.domain.model.Result
import com.example.countrylistexam.core.common.data.provider.ResponseProvider
import com.example.countrylistexam.country.domain.constant.ApiErrorEnum
import com.example.countrylistexam.country.domain.exception.SomeApiSpecificException
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.HttpException
import retrofit2.Response
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
            Result.Error(handleThrowable(e))
        }
    }

    override suspend fun <T, V> handleOnError(response: Response<T>): Result<V> {

        return try {
            val throwable = when {
                !response.message().isNullOrEmpty() ->
                    handleErrorByMessage(response.code(), response.message())

                else ->
                    handleErrorByCode(response.code(), response.message())
            }
            return Result.Error(throwable)
        } catch (e: Throwable) {
            Result.Error(handleThrowable(e))
        }
    }

    private fun handleThrowable(throwable: Throwable): Throwable {
        return when (throwable) {
            is HttpException ->
                handleErrorByCode(throwable.code(), throwable.message())
            else -> throwable
        }
    }

    private fun handleErrorByMessage(code: Int, message: String?) : Throwable {
       return when {
            message?.contains(ApiErrorEnum.MISSING_PARAM_VALIDATION.value.toChar()) == true -> {
                SomeApiSpecificException(
                    context,
                    message
                )
            }
            else -> handleErrorByCode(code, message)
        }
    }

    private fun handleErrorByCode(code: Int, message: String?) : Throwable {
        return when (code) {
            400 -> BadRequestException(context, message)
            401 -> UnAuthorizedException(context, message)
            403 -> ForbiddenException(context, message)
            404 -> NotFoundException(context, message)
            500 -> InternalServerError(context, message)
            else -> UnknownErrorException(context, message)
        }
    }
}