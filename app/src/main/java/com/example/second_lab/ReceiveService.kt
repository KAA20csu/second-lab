package com.example.second_lab

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.net.URL


class ReceiveService {

    private val MODELS_DOMAIN = "https://develtop.ru/study/new_text.json"
    fun getItems() : String {
        return URL(MODELS_DOMAIN).openStream()
            .bufferedReader()
            .use { it.readText() }
    }
    fun serializeItems(response: String): List<ReceiveModel> {
        val mapper = jacksonObjectMapper()
        return mapper.readValue(response)
    }

    fun getCards(items: List<ReceiveModel>): MutableList<AbstractCard> {
        val cards : MutableList<AbstractCard> = listOf<AbstractCard>().toMutableList()
        for (card in items) {
            cards.add(getCardType(card))
        }
        return cards
    }
    private fun getCardType(item: ReceiveModel): AbstractCard {
        if(item.img == null) {
            return ThirdCard(item.title, item.subtitle)
        }
        if(item.hasBag == null && item.isCircle == null) {
            return SecondCard(item.img, item.title, item.subtitle)
        }

        if(item.isCircle != null) {
            return FourthCard(item.img, item.title, item.subtitle)
        }
        if(item.hasBag != null) {
            return FirstCard(item.img, item.title, item.subtitle, item.hasBag)
        }
        return ThirdCard(item.title, item.subtitle)
    }
}