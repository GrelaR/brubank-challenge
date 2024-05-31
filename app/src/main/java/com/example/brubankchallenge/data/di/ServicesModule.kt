package com.example.brubankchallenge.data.di

import com.example.brubankchallenge.data.api.GetMoviesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class ServicesModule {

    @Singleton
    @Provides
    fun provideGetMoviesService(retrofit: Retrofit): GetMoviesService {
        return retrofit.create(GetMoviesService::class.java)
    }
}
