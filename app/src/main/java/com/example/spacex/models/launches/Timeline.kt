package com.example.spacex.models.launches


import com.google.gson.annotations.SerializedName

data class Timeline(
    @SerializedName("webcast_liftoff")
    val webcastLiftoff: Any?
)