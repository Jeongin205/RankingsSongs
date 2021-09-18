package com.example.rankingssongs.data
import com.google.gson.annotations.SerializedName

data class Attr(
    @SerializedName("page")
    val page: String,
    @SerializedName("perPage")
    val perPage: String,
    @SerializedName("total")
    val total: String,
    @SerializedName("totalPages")
    val totalPages: String
)