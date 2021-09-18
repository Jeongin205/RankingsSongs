package com.example.rankingssongs

import com.example.rankingssongs.data.Track
import com.example.rankingssongs.data.Tracks
import com.google.gson.annotations.SerializedName

data class SongData(
    val number:String,
    val song: String,
    val singer: String
)
