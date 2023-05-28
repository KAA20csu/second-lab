package com.example.second_lab

import javax.inject.Inject

class UseCaseImplementation @Inject constructor(
    private val repository: Repository
): UseCaseInterface {

    override suspend fun getModels(): List<ReceiveModel> {
        return repository.getModels()
    }
}