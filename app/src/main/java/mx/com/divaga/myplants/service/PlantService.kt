package mx.com.divaga.myplants.service

import androidx.lifecycle.MutableLiveData
import mx.com.divaga.myplants.dto.Plant

class PlantService {

    fun fetchPlants(plantName: String) : MutableLiveData<ArrayList<Plant>>{
        return MutableLiveData<ArrayList<Plant>>()
    }
}