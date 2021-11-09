package com.example.spacex.models.launches


import com.google.gson.annotations.SerializedName

data class LaunchFailureDetails(
    @SerializedName("altitude")
    val altitude: Any?,
    @SerializedName("reason")
    val reason: String?,
    @SerializedName("time")
    val time: Any?
)