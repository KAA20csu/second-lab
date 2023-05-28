package com.example.second_lab

import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    fun provideTextUseCase(repository: Repository): UseCaseInterface {
        return UseCaseImplementation(repository)
    }
}