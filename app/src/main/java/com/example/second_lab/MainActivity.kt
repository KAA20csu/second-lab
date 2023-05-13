package com.example.second_lab

import android.os.Bundle
import android.os.StrictMode
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.example.second_lab.common.Common
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService: RetrofitServices
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
//        mService = Common.retrofitService
//        val res = mService.getMovieList().enqueue(object : Callback<MutableList<ReceiveModel>> {
//            override fun onFailure(call: Call<MutableList<ReceiveModel>>, t: Throwable) {
//                val hehe = 1
//            }
//
//            override fun onResponse(call: Call<MutableList<ReceiveModel>>, response: Response<MutableList<ReceiveModel>>) {
//                val res = response.body() as MutableList<ReceiveModel>
//                val hehe = 1
//            }
//        })

    }
}