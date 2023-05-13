package com.example.second_lab.common

import com.example.second_lab.RetrofitClient
import com.example.second_lab.RetrofitServices

object Common {
    private val BASE_URL = "https://develtop.ru/study/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}