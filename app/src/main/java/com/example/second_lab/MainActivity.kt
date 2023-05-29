package com.example.second_lab

import android.os.Bundle
import android.os.StrictMode
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var viewModelFactory: NewTextViewModelFactory
    @Inject
    lateinit var viewModel : NewTextViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component = DaggerAppComponent.builder()
            .build()
        component.inject(this)

        val service = ReceiveService()
//        viewModel = ViewModelProvider(this).get(NewTextViewModel::class.java)

        viewModel.newText.observe(this) { newText ->
            val cards = service.getCards(newText)
            val ft = supportFragmentManager.beginTransaction()
            val fragmentTest = MainFragment(cards)
            ft.replace(R.id.fragmentContainerView, fragmentTest)
            ft.commit()
        }
        viewModel.loadNewText()
    }
}