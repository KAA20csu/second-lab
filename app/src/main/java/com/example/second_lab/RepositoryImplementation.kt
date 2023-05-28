package com.example.second_lab

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RepositoryImplementation @Inject constructor(private val newsApi: JsonApi) : Repository {
    override suspend fun getModels(): List<ReceiveModel> {
        val response = withContext(Dispatchers.IO) {
            newsApi.getModels()
        }
        if (response.isSuccessful) {
            val resp = response.body()
            return resp!!
        }
        throw Exception()
    }
}