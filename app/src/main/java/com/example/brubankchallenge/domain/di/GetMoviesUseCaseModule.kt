package com.example.brubankchallenge.domain.di

import com.example.brubankchallenge.data.repository.GetMoviesRepositoryImpl
import com.example.brubankchallenge.domain.repository.GetMoviesRepository
import com.example.brubankchallenge.domain.usecase.GetMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object GetMoviesUseCaseRepositoryModule {
    @Provides
    fun provideGetMoviesRepositoryImpl(getMoviesRepositoryImpl: GetMoviesRepositoryImpl): GetMoviesRepository {
        return getMoviesRepositoryImpl
    }
}

@Module
@InstallIn(ViewModelComponent::class)
object GetMoviesUseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideGetMoviesUseCase(repository: GetMoviesRepository): GetMoviesUseCase {
        return GetMoviesUseCase(repository)
    }
}
