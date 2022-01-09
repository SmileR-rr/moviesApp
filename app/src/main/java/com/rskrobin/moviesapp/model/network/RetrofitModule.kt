package com.rskrobin.moviesapp.model.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.rskrobin.moviesapp.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideMovieService(): MovieApi = Retrofit.Builder()
        .client(
            OkHttpClient().newBuilder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
        )
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .build().create()
}
