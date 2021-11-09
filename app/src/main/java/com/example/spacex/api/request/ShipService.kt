package com.example.spacex.api.request

import com.example.spacex.models.Ship
import com.example.spacex.models.launches.Launches
import retrofit2.Response
import retrofit2.http.GET

interface ShipService {
    @GET("ships")
    suspend fun shipList(): Response<List<Ship>>

    @GET("launches")
    suspend fun missionList(): Response<List<Launches>>
}