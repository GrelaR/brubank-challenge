package com.example.brubankchallenge.domain.di

import com.example.brubankchallenge.domain.repository.MovieRepository
import com.example.brubankchallenge.domain.usecase.GetSubscribedMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object GetSubscribedMoviesUseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideGetSubscribedMoviesUseCaseModule(repository: MovieRepository): GetSubscribedMoviesUseCase {
        return GetSubscribedMoviesUseCase(repository)
    }
}
