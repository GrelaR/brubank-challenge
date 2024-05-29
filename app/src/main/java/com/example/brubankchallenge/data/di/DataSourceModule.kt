package com.example.brubankchallenge.data.di

import com.example.brubankchallenge.data.api.GetMoviesService
import com.example.brubankchallenge.data.datasource.GetGenresDataSource
import com.example.brubankchallenge.data.datasource.GetGenresDataSourceImpl
import com.example.brubankchallenge.data.datasource.GetMoviesDataSource
import com.example.brubankchallenge.data.datasource.GetMoviesDataSourceImpl
import com.example.brubankchallenge.data.datasource.MoviePagingSource
import com.example.brubankchallenge.data.datasource.SearchMoviesDataSource
import com.example.brubankchallenge.data.datasource.SearchMoviesDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    fun provideGetMoviesDataSource(getMoviesService: GetMoviesService): GetMoviesDataSource {
        return GetMoviesDataSourceImpl(getMoviesService)
    }

    @Provides
    fun provideSearchMoviesDataSource(getMoviesService: GetMoviesService): SearchMoviesDataSource {
        return SearchMoviesDataSourceImpl(getMoviesService)
    }

    @Provides
    fun provideGetGenresDataSource(getMoviesService: GetMoviesService): GetGenresDataSource {
        return GetGenresDataSourceImpl(getMoviesService)
    }

    @Provides
    fun provideMoviesPagingSource(
        getMoviesDataSource: GetMoviesDataSource,
        searchMoviesDataSource: SearchMoviesDataSource
    ): MoviePagingSource {
        return MoviePagingSource(getMoviesDataSource, searchMoviesDataSource)
    }

}
