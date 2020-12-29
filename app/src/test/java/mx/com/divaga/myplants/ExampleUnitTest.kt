package mx.com.divaga.myplants

import mx.com.divaga.myplants.dto.Plant
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun addition_isNotCorrect(){
        assertEquals(3, 2 + 1)
    }

    @Test
    fun addTwoandThree_equalsFive(){
        assertEquals(5, 2 + 3)
    }


    @Test
    fun addThreeandThree_equalsSix(){
        assertEquals(6 , 3 + 3)
    }

    @Test
    fun addFiveandtwo_equalsSeven(){
        assertEquals(7 , 5 + 2)
        // 
    }

    @Test
    fun addFiveandthree_equalsEight (){
        assertEquals(8 , 5 + 3)

    }

    @Test
    fun confirmEasternRedbud_outputsEasternRedbud(){

        var plant: Plant = Plant("Cercis", "Canadiense", "Eastern Redbud")

        assertEquals("Eastern Redbud", plant.toString())
    }


}