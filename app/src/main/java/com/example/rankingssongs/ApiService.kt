package com.example.rankingssongs

import com.example.rankingssongs.data.TopTrack
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("2.0/")
    fun getTrack(@Query("method") method : String,
    @Query("api_key")api_key: String,
    @Query("format") format : String): Call<TopTrack>
}