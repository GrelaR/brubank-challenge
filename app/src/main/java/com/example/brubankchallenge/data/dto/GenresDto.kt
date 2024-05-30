package com.example.brubankchallenge.data.dto

import com.google.errorprone.annotations.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class GenresDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)
