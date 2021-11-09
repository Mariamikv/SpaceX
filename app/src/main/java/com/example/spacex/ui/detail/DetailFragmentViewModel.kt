package com.example.spacex.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spacex.api.repository.ShipRepository
import com.example.spacex.models.launches.Launches
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailFragmentViewModel(private val shipRepository: ShipRepository): ViewModel() {

    private val missionLiveData = MutableLiveData<List<Launches>>().apply {
        mutableListOf<Launches>()
    }
    val _missionLiveData: LiveData<List<Launches>> = missionLiveData

    fun init(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                getMissionData()
            }
        }
    }

    private suspend fun getMissionData(){
        val missionData = shipRepository.getMissionList()
        if(missionData.isSuccessful){
            val items = missionData.body()
            missionLiveData.postValue(items)
        }
    }
}