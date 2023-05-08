package com.example.second_lab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cards : MutableList<AbstractCard> = listOf<AbstractCard>().toMutableList()
        // for testing requests
        val service = ReceiveService()
        val objects = service.getQuestions()
        val test1 = service.serializeQuestions(objects)

        for (card in test1) {
            if( card.img != null
                && card.title != null
                && card.subtitle != null
                && card.hasBag != null) {
                cards.add(FirstCard(card.img, card.title, card.subtitle, card.hasBag))
            }

            if(card.img != null
                && card.title != null
                && card.subtitle != null
                && card.hasBag == null
                && card.isCircle == null) {
                cards.add(SecondCard(card.img, card.title, card.subtitle))
            }
            if(card.img == null
                && card.title != null
                && card.subtitle != null
                && card.hasBag == null
                && card.isCircle == null) {
                cards.add(ThirdCard(card.title, card.subtitle))
            }
            if(card.img != null
                && card.title != null
                && card.subtitle != null
                && card.hasBag == null
                && card.isCircle != null) {
                cards.add(FourthCard(card.img, card.title, card.subtitle))
            }
        }

        val ft = supportFragmentManager.beginTransaction()
        val fragmentTest = MainFragment(cards)
        ft.replace(R.id.fragmentContainerView, fragmentTest)
        ft.commit()
    }
}