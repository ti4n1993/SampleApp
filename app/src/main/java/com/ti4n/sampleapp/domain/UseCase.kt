package com.ti4n.sampleapp.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import timber.log.Timber

abstract class UseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(parameters: P): Result<R> {
        return runCatching { withContext(coroutineDispatcher) { execute(parameters) } }.onFailure {
            Timber.d(
                it
            )
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): R
}

abstract class NoInputUseCase<R>(private val coroutineDispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(): Result<R> {
        return runCatching { withContext(coroutineDispatcher) { execute() } }.onFailure {
            Timber.d(
                it
            )
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(): R
}