package com.example.rankingssongs.data
import com.google.gson.annotations.SerializedName

data class Artist(
    @SerializedName("name")
    val name: String
)