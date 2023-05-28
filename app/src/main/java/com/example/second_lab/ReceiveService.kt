package com.example.second_lab



class ReceiveService {
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