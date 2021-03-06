package com.ti4n.sampleapp.di

import android.content.Context
import androidx.room.Room
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.ti4n.sampleapp.BaseUrl
import com.ti4n.sampleapp.DataBaseName
import com.ti4n.sampleapp.api.ApiService
import com.ti4n.sampleapp.db.DataBase
//import com.ti4n.sampleapp.db.DataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun okHttp() = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    private val json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun apiService(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BaseUrl).build().create<ApiService>()

    @Provides
    @Singleton
    fun database(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        DataBase::class.java, DataBaseName
    ).build()
}