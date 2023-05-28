package com.example.second_lab

interface Repository {
    suspend fun getModels() : List<ReceiveModel>
}