package mx.com.divaga.myplants.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.com.divaga.myplants.dto.Plant
import mx.com.divaga.myplants.service.PlantService

class MainViewModel : ViewModel() {
    var plants: MutableLiveData<ArrayList<Plant>> = MutableLiveData<ArrayList<Plant>>()
    var plantService: PlantService = PlantService()

    fun fetchPlants(plantName: String) {
        plants = plantService.fetchPlants(plantName)
    }
    // TODO: Implement the ViewModel
}