package com.example.zadanie03

import net.objecthunter.exp4j.ExpressionBuilder
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun firstTest()
    {
        val expression = ExpressionBuilder("2+9").build()
        val result = expression.evaluate().toInt()
        assertEquals(11, result)
    }
    @Test
    fun secondTest()
    {
        val expression = ExpressionBuilder("9-2").build()
        val result = expression.evaluate().toInt()
        assertEquals(7, result)
    }
    @Test
    fun thirdTest()
    {
        val expression = ExpressionBuilder("9*2").build()
        val result = expression.evaluate().toInt()
        assertEquals(18, result)
    }
    @Test
    fun fourthTest()
    {
        val expression = ExpressionBuilder("5/5").build()
        val result = expression.evaluate().toInt()
        assertEquals(1, result)
    }
    @Test
    fun fifthTest()
    {
        val expression = ExpressionBuilder("9/0").build()
        assertThrows(ArithmeticException::class.java)
        {
            expression.evaluate()
        }
    }

    @Test
    fun sixthTest()
    {
        val expression = ExpressionBuilder("14+14").build()
        val result = expression.evaluate().toInt()
        assertEquals(28, result)
    }
    @Test
    fun seventhTest()
    {
        val expression = ExpressionBuilder("15-20").build()
        val result = expression.evaluate().toInt()
        assertEquals(-5, result)
    }
    @Test
    fun eighthTest()
    {
        val expression = ExpressionBuilder("9*9").build()
        val result = expression.evaluate().toInt()
        assertEquals(81, result)
    }

    @Test
    fun ninthTest()
    {
        val expression = ExpressionBuilder("17+6").build()
        val result = expression.evaluate().toInt()
        assertEquals(23, result)
    }
    @Test
    fun tenthTest()
    {
        val expression = ExpressionBuilder("6-17").build()
        val result = expression.evaluate().toInt()
        assertEquals(-11, result)
    }
    @Test
    fun eleventhTest()
    {
        val expression = ExpressionBuilder("4*6").build()
        val result = expression.evaluate().toInt()
        assertEquals(24, result)
    }

    @Test
    fun twelveTest()
    {
        val expression = ExpressionBuilder("7+9").build()
        val result = expression.evaluate().toInt()
        assertEquals(16, result)
    }
    @Test
    fun thirteenTest()
    {
        val expression = ExpressionBuilder("9-7").build()
        val result = expression.evaluate().toInt()
        assertEquals(2, result)
    }
    @Test
    fun fourteenthTest()
    {
        val expression = ExpressionBuilder("8*8").build()
        val result = expression.evaluate().toInt()
        assertEquals(64, result)
    }
    @Test
    fun fifteenthTest()
    {
        val expression = ExpressionBuilder("99+99").build()
        val result = expression.evaluate().toInt()
        assertEquals(198, result)
    }
    @Test
    fun sixteenthTest()
    {
        val expression = ExpressionBuilder("2-1").build()
        val result = expression.evaluate().toInt()
        assertEquals(1, result)
    }
    @Test
    fun seventeenthTest()
    {
        val expression = ExpressionBuilder("100*10").build()
        val result = expression.evaluate().toInt()
        assertEquals(1000, result)
    }
    @Test
    fun eighteenthTest()
    {
        val expression = ExpressionBuilder("17+12").build()
        val result = expression.evaluate().toInt()
        assertEquals(29, result)
    }
    @Test
    fun nineteenthTest()
    {
        val expression = ExpressionBuilder("99-100").build()
        val result = expression.evaluate().toInt()
        assertEquals(-1, result)
    }
    @Test
    fun twentiethTest()
    {
        val expression = ExpressionBuilder("13*13").build()
        val result = expression.evaluate().toInt()
        assertEquals(169, result)
    }
}