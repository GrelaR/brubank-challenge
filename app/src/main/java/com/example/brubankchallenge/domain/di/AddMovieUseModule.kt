package com.example.brubankchallenge.domain.di

import com.example.brubankchallenge.data.repository.MovieRepositoryImpl
import com.example.brubankchallenge.domain.repository.MovieRepository
import com.example.brubankchallenge.domain.usecase.AddMovieUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AddMovieRepositoryModule {
    @Provides
    fun provideAddMovieDataUseModule(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository {
        return movieRepositoryImpl
    }
}

@Module
@InstallIn(ViewModelComponent::class)
object AddMovieUseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideAddMovieUseCaseModule(repository: MovieRepository): AddMovieUseCase {
        return AddMovieUseCase(repository)
    }
}
