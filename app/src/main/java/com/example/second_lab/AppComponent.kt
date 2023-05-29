package com.example.second_lab

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitClient::class, UseCaseModule::class, AppModule::class])
interface AppComponent {
    fun inject(mainFragment: MainFragment)
}