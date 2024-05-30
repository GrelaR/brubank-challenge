package com.example.brubankchallenge.data.mapper

import com.example.brubankchallenge.data.dto.GenresDto
import com.example.brubankchallenge.data.dto.MovieDto
import com.example.brubankchallenge.domain.model.Genre
import com.example.brubankchallenge.domain.model.Movie


fun MovieDto.toDomain(): Movie {
    return Movie(
        id = id,
        title = title,
        posterPath = posterPath,
        genresIds = genresIds,
        overview = overview,
        releaseDate = releaseDate
    )
}

fun List<MovieDto>.toMovieDomain(): List<Movie> {
    return this.map { it.toDomain() }
}

fun GenresDto.toDomain(): Genre {
    return Genre(
        id = id,
        name = name
    )
}

fun List<GenresDto>.toGenresDomain(): List<Genre> {
    return this.map { it.toDomain() }
}
