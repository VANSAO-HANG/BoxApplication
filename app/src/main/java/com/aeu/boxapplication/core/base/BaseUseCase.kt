package com.aeu.boxapplication.core.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class BaseUseCase<in Params, out Result> {

    abstract suspend fun execute(params: Params): Result

    suspend operator fun invoke(params: Params): Result {
        return withContext(Dispatchers.IO) {
            execute(params)
        }
    }
}

// For use cases without parameters
abstract class BaseUseCaseNoParams<out Result> {

    abstract suspend fun execute(): Result

    suspend operator fun invoke(): Result {
        return withContext(Dispatchers.IO) {
            execute()
        }
    }
}
