package com.example.second_lab

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val baseUrl = "https://develtop.ru/study/"

    private val retrofit by lazy {
        val okHttpClient = OkHttpClient.Builder()
            .build()

        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    val jsonApi: JsonApi by lazy {
        retrofit.create(JsonApi::class.java)
    }
}