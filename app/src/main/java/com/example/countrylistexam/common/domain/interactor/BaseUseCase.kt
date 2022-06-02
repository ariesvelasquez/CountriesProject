package com.example.countrylistexam.common.domain.interactor

import com.example.countrylistexam.common.domain.model.NetworkResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class BaseUseCase<Type, in Params>() where Type : Any {

    abstract suspend fun run(params: Params? = null): NetworkResult<Type>

    fun execute(
        scope: CoroutineScope,
        params: Params?,
        onLaunch: () -> Unit = {},
        onSuccess: (Type) -> Unit,
        onError: (Throwable) -> Unit = {},
        onComplete: () -> Unit = {}
    ) {

        scope.launch {
            onLaunch.invoke()
            try {
                when (val result = run(params)) {
                    is NetworkResult.Error -> onError.invoke(result.e)
                    is NetworkResult.Success -> onSuccess.invoke(result.data)
                }
            } catch (e: Exception) {
                onError.invoke(e)
            } finally {
                onComplete.invoke()
            }
        }
    }
}