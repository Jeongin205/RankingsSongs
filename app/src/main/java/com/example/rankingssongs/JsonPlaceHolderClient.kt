package com.example.rankingssongs

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object JsonPlaceHolderClient {
    private const val baseUrl = "https://ws.audioscrobbler.com/"
    private var instance: Retrofit? = null

    fun getApiService(): ApiService = getInstance().create(ApiService::class.java)

    private fun getInstance(): Retrofit {
        if (instance == null) {
            instance = Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build()
            return instance!!
        }
        return  instance!!
    }
}