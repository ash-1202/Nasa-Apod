package com.walmart.coding.challenge.model

import com.google.gson.annotations.SerializedName

data class ApodPost(
    @SerializedName("api_key")
    val apiKey: String?,
    @SerializedName("start_date")
    val startDate: String?,
    @SerializedName("end_date")
    val endDate: String?
)