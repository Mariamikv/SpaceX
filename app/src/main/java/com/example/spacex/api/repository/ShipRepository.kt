package com.example.spacex.api.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.spacex.api.request.ShipService
import com.example.spacex.models.Ship
import com.example.spacex.utils.Result

class ShipRepository(private val shipService: ShipService) {
    suspend fun getShipList() = shipService.shipList()

//    suspend fun getShipList(): MutableLiveData<List<Ship>> {
//        val shipLiveData = MutableLiveData<List<Ship>>().apply {
//            mutableListOf<Ship>()
//        }
//        val _shipLiveData: LiveData<List<Ship>> = shipLiveData
//
//        val response = shipService.shipList()
//
//        if(response.isSuccessful){
//            Result.Success(response.body())
//        }else{
//            val errorMsg = response.errorBody()?.toString()
//            response.errorBody()?.close()
//            if (errorMsg != null) {
//                Result.Error(errorMsg)
//            }
//        }
//
//        return shipLiveData
//    }

    suspend fun getMissionList() = shipService.missionList()
}