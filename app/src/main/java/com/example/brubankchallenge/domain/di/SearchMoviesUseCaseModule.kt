package com.example.brubankchallenge.domain.di

import com.example.brubankchallenge.data.repository.SearchMoviesRepositoryImpl
import com.example.brubankchallenge.domain.repository.SearchMoviesRepository
import com.example.brubankchallenge.domain.usecase.SearchMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SearchMoviesRepositoryModule {
    @Provides
    fun provideSearchMoviesRepositoryImpl(searchMoviesRepositoryImpl: SearchMoviesRepositoryImpl): SearchMoviesRepository {
        return searchMoviesRepositoryImpl
    }
}

@Module
@InstallIn(ViewModelComponent::class)
object SearchMoviesUseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideSearchMoviesUseCase(repository: SearchMoviesRepository): SearchMoviesUseCase {
        return SearchMoviesUseCase(repository)
    }
}
