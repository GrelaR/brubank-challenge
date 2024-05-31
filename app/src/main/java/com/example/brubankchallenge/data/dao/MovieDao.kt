package com.example.brubankchallenge.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.brubankchallenge.data.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: MovieEntity)

    @Query("SELECT * FROM subscription_movies")
    fun getSubscriptionMovies(): Flow<List<MovieEntity>>

    @Delete
    suspend fun removeMovie(movie: MovieEntity)

}
