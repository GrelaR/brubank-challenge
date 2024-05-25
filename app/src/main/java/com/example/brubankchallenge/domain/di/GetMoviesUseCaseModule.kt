package com.example.brubankchallenge.domain.di

import com.example.brubankchallenge.data.repository.GetMoviesByGenreRepositoryImpl
import com.example.brubankchallenge.domain.repository.GetMoviesByGenreRepository
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
    fun provideGetMoviesByGenreRepositoryImpl(getMoviesByGenreRepositoryImpl: GetMoviesByGenreRepositoryImpl): GetMoviesByGenreRepository {
        return getMoviesByGenreRepositoryImpl
    }
}

@Module
@InstallIn(ViewModelComponent::class)
object GetMoviesUseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideGetSecurityCenterDataUseCase(repository: GetMoviesByGenreRepository): GetMoviesUseCase {
        return GetMoviesUseCase(repository)
    }
}
