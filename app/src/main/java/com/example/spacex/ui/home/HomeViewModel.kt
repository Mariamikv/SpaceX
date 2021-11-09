package com.example.spacex.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacex.api.repository.ShipRepository
import com.example.spacex.models.Ship
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel (private val shipRepository: ShipRepository): ViewModel() {

    private val shipLiveData = MutableLiveData<List<Ship>>().apply {
        mutableListOf<Ship>()
    }
    val _shipLiveData: LiveData<List<Ship>> = shipLiveData

    fun init(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                getShipData()
            }
        }
    }

    private suspend fun getShipData(){
        val shipData = shipRepository.getShipList()
        if(shipData.isSuccessful){
            val items = shipData.body()
            shipLiveData.postValue(items)
        }
    }

}















