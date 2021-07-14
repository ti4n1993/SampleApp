package com.ti4n.sampleapp.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import com.ti4n.sampleapp.util.Result
import timber.log.Timber

abstract class FlowUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {
    operator fun invoke(parameters: P): Flow<Result<R>> = execute(parameters)
        .catch { e ->
            Timber.d(e)
            emit(Result.Error(Exception(e)))
        }
        .flowOn(coroutineDispatcher)

    protected abstract fun execute(parameters: P): Flow<Result<R>>
}

abstract class SimpleFlowUseCase<R>(private val coroutineDispatcher: CoroutineDispatcher) {
    operator fun invoke(): Flow<Result<R>> = execute()
        .catch { e ->
            Timber.d(e)
            emit(Result.Error(Exception(e)))
        }
        .flowOn(coroutineDispatcher)

    protected abstract fun execute(): Flow<Result<R>>
}