package com.example.countrylistexam.common.domain.interactor

import com.example.countrylistexam.common.domain.model.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class BaseUseCase<Type, in Params>() where Type : Any {

    abstract suspend fun run(params: Params? = null): Result<Type>

    fun execute(
        scope: CoroutineScope,
        params: Params? = null,
        onLaunch: () -> Unit = {},
        onSuccess: (Type) -> Unit,
        onError: (Throwable) -> Unit = {},
        onComplete: () -> Unit = {}
    ) {

        scope.launch {
            onLaunch.invoke()
            try {
                when (val result = run(params)) {
                    is Result.Error -> onError.invoke(result.e)
                    is Result.Success -> onSuccess.invoke(result.data)
                }
            } catch (e: Exception) {
                onError.invoke(e)
            } finally {
                onComplete.invoke()
            }
        }
    }
}