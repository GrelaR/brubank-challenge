package com.example.brubankchallenge.data.dto

import com.google.errorprone.annotations.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class GenresResponseDto(
    @SerializedName("genres")
    val genres: List<GenresDto>
)
