package com.example.second_lab

import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideTextUseCase(repository: Repository): UseCaseInterface {
        return UseCaseImplementation(repository)
    }
}