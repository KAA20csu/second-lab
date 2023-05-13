package com.example.second_lab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Request for cards
        val service = ReceiveService()
        val items = service.getItems()
        val receivedModels = service.serializeItems(items)

        // Set cards to the recycler view
        val ft = supportFragmentManager.beginTransaction()
        val fragmentTest = MainFragment(service.getCards(receivedModels))
        ft.replace(R.id.fragmentContainerView, fragmentTest)
        ft.commit()
    }
}