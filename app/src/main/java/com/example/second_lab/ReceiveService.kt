package com.example.second_lab

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.net.URL

class ReceiveService {
    companion object {
        const val MODELS_DOMAIN = "https://develtop.ru/study/new_text.json"
    }
    fun getQuestions() : String {
        return URL(MODELS_DOMAIN).openStream()
            .bufferedReader()
            .use { it.readText() }
    }
    fun serializeQuestions(response: String): List<ReceiveModel> {
        val mapper = jacksonObjectMapper()
        return mapper.readValue(response)
    }
}