package com.example.second_lab

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object RetrofitClient {
    private const val BASE_URL = "https://develtop.ru/study/"
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): JsonApi {
        return retrofit.create(JsonApi::class.java)
    }

}