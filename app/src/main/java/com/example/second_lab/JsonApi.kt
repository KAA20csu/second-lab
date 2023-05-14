package com.example.second_lab

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface JsonApi {

    @GET("new_text.json")
    suspend fun getModels(): Response<List<ReceiveModel>>
}