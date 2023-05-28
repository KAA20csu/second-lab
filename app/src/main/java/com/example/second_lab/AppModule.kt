package com.example.second_lab

import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class AppModule {

    @Provides
    fun provideRepository(jsonApi: JsonApi): Repository {
        return RepositoryImplementation(jsonApi)
    }
}