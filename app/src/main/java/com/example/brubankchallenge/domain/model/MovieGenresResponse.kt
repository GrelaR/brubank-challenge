package com.example.brubankchallenge.domain.model

import com.google.errorprone.annotations.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class MovieGenresResponse(
    @SerializedName("genres")
    val genres: List<Genre>
)
