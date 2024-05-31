package com.example.brubankchallenge.data.mapper

import com.example.brubankchallenge.data.dto.GenresDto
import com.example.brubankchallenge.data.dto.MovieDto
import com.example.brubankchallenge.data.entity.MovieEntity
import com.example.brubankchallenge.domain.model.Genre
import com.example.brubankchallenge.domain.model.Movie


fun MovieDto.toMovieDomain(): Movie {
    return Movie(
        id = this.id ?: 0,
        title = this.title ?: "",
        posterPath = posterPath ?: "",
        genresIds = genresIds ?: emptyList(),
        overview = overview ?: "",
        releaseDate = releaseDate ?: "",
    )
}

fun List<MovieDto>.toMovieDomain(): List<Movie> {
    return this.map { it.toMovieDomain() }
}

fun GenresDto.toGenresDomain(): Genre {
    return Genre(
        id = id,
        name = name
    )
}

fun List<GenresDto>.toGenresDomain(): List<Genre> {
    return this.map { it.toGenresDomain() }
}
fun MovieEntity.toDomain(): Movie {
    return Movie(
        genresIds = genresIds,
        id = id,
        overview = overview,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title
    )
}

fun Movie.toEntity(): MovieEntity {
    return MovieEntity(
        genresIds = genresIds,
        id = id,
        overview = overview,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title
    )
}
