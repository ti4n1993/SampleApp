package com.ti4n.sampleapp.repository

interface Repository<T> {

    suspend fun invoke(): T
}