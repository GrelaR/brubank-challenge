package com.example.brubankchallenge.domain.di

import com.example.brubankchallenge.data.repository.GetGenresRepositoryImpl
import com.example.brubankchallenge.domain.repository.GetGenresRepository
import com.example.brubankchallenge.domain.usecase.GetGenresUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object GetGenresRepositoryModule {
    @Provides
    fun provideGetGenresRepositoryImpl(getGenresRepositoryImpl: GetGenresRepositoryImpl): GetGenresRepository {
        return getGenresRepositoryImpl
    }
}

@Module
@InstallIn(ViewModelComponent::class)
object GetGenresUseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideGetGenresUseCase(repository: GetGenresRepository): GetGenresUseCase {
        return GetGenresUseCase(repository)
    }
}
