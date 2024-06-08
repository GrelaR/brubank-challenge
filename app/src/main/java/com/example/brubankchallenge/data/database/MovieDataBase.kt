package com.example.brubankchallenge.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.brubankchallenge.data.converters.Converters
import com.example.brubankchallenge.data.dao.MovieDao
import com.example.brubankchallenge.data.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

}
