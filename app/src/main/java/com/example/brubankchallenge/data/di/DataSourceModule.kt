package com.example.brubankchallenge.data.di

import com.example.brubankchallenge.data.api.GetMoviesService
import com.example.brubankchallenge.data.datasource.GetMoviesGenresDataSource
import com.example.brubankchallenge.data.datasource.GetMoviesGenresDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    fun provideGetMoviesByGenresDataSource(moviesByGenresService: GetMoviesService): GetMoviesGenresDataSource {
        return GetMoviesGenresDataSourceImpl(moviesByGenresService)
    }
}
