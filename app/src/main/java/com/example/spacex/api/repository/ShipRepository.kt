package com.example.spacex.api.repository

import com.example.spacex.api.request.ShipService

class ShipRepository(private val shipService: ShipService) {
    suspend fun getShipList() = shipService.shipList()

    suspend fun getMissionList() = shipService.missionList()
}