package com.example.brubankchallenge.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.brubankchallenge.data.mapper.toMovieDomain
import com.example.brubankchallenge.domain.model.Movie
import retrofit2.HttpException
import java.io.IOException

class MoviePagingSource(
    private val getMoviesDataSource: GetMoviesDataSource,
    private val searchMoviesDataSource: SearchMoviesDataSource,
    private val query: String? = null
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: 1
        return try {
            val response = if (query == null) getMoviesDataSource.getMovies(page)
            else searchMoviesDataSource.searchMovies(query, page)
            if (response.isSuccessful) {
                val moviesDto = response.body()?.results ?: emptyList()
                val movies = moviesDto.toMovieDomain()
                LoadResult.Page(
                    data = movies,
                    prevKey = if (page == 1) null else page - 1,
                    nextKey = if (movies.isEmpty()) null else page + 1
                )
            } else {
                LoadResult.Error(HttpException(response))
            }
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
