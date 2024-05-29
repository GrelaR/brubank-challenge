package com.example.brubankchallenge.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.brubankchallenge.data.datasource.GetMoviesDataSource
import com.example.brubankchallenge.domain.model.Movie
import retrofit2.HttpException
import java.io.IOException

class MoviePagingSource(
    private val getMoviesDataSource: GetMoviesDataSource
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: 1
        return try {
            val response = getMoviesDataSource.getMovies(page)
            if (response.isSuccessful) {
                val movies = response.body()?.results ?: emptyList()
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
