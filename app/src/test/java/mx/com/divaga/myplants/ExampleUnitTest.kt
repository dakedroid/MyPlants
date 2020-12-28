package mx.com.divaga.myplants

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
        assertEquals(3, 1 + 2)
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


}