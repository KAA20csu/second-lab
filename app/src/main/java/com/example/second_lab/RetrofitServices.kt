package com.example.second_lab

import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {
    @GET("https://develtop.ru/study/new_text.json")
    fun getMovieList(): Call<MutableList<ReceiveModel>>
}