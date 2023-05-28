package com.example.second_lab

interface UseCaseInterface  {
    suspend fun getModels(): List<ReceiveModel>
}