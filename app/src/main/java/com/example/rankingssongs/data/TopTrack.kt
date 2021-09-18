package com.example.rankingssongs.data
import com.google.gson.annotations.SerializedName

data class TopTrack(
    @SerializedName("tracks")
    val tracks: Tracks
)