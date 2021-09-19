package com.example.rankingssongs.data
import com.google.gson.annotations.SerializedName

data class Track(
    @SerializedName("artist")
    val artist: Artist,
    @SerializedName("name")
    val name: String
)