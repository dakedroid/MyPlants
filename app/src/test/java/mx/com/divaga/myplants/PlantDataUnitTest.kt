package mx.com.divaga.myplants

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import mx.com.divaga.myplants.dto.Plant
import mx.com.divaga.myplants.service.PlantService
import mx.com.divaga.myplants.ui.main.MainViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.rules.TestRule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PlantDataUnitTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    lateinit var mViewModel: MainViewModel

    var plantService = mockk<PlantService>()


    @Test
    fun confirmEasternRedbud_outputsEasternRedbud(){

        var plant: Plant = Plant("Cercis", "Canadiense", "Eastern Redbud")

        assertEquals("Eastern Redbud", plant.toString())
    }

    @Test
    fun searchForRedbud_returnsRedbud(){

        givenAfeedOfMockedPlantDataAreAvailable()
        whenSearchForRedbud()
        thenResultContainsEasternRedbud()
        thenVerifyunctionsInvoke()

    }


    private fun givenAfeedOfMockedPlantDataAreAvailable() {
        mViewModel = MainViewModel()
        createMockData()
    }

    private fun createMockData() {

        var allPlantsLiveData = MutableLiveData<ArrayList<Plant>>()

        var allPlants = ArrayList<Plant>()

        var redbud  = Plant("Cercis", "canadensis", "Eastern Redbud")
        var redOak = Plant("Quercus", "rubra", "Red Oak")
        var whiteOak = Plant("Quercus", "alba", "White Oak")

        allPlants.add(redbud)
        allPlants.add(redOak)
        allPlants.add(whiteOak)

        allPlantsLiveData.postValue(allPlants)

        every {plantService.fetchPlants(or("Redbud", "Quercus"))} returns allPlantsLiveData
        every {plantService.fetchPlants(not(or("Redbud", "Quercus")))} returns MutableLiveData<ArrayList<Plant>>()

        mViewModel.plantService = plantService
    }

    private fun whenSearchForRedbud() {
        mViewModel.fetchPlants("Redbud")
    }

    private fun thenResultContainsEasternRedbud() {
        var redbudFound = false
        mViewModel.plants.observeForever {
            assertNotNull(it)
            assertTrue(it.size > 0)
            it.forEach{
                if(it.genus == "Cercis" && it.species == "canadensis" && it.common.contains("Eastern Redbud")){
                    redbudFound = true
                }
            }
        }
        assertTrue(redbudFound)
    }


    private fun thenVerifyunctionsInvoke() {
        verify { plantService.fetchPlants("Redbud") }
        verify(exactly = 0) {plantService.fetchPlants("Maple")}
        confirmVerified(plantService )
    }

    @Test
    fun searchForGarbage_returnsNothing(){
        givenAfeedOfMockedPlantDataAreAvailable()
        whenISearchForGarbage()
        thenIGetZeroResults()
    }

    private fun whenISearchForGarbage() {
        mViewModel.fetchPlants("asdfghjklñ")
    }

    private fun thenIGetZeroResults() {
        mViewModel.plants.observeForever{
            assertEquals(0, it.size)
        }
    }


}