package com.willlmadison.operarray

import com.willmadison.operarray.*
import org.junit.Assert.*
import java.util.Arrays
import java.util.function.LongBinaryOperator
import org.junit.Test

class OperarrayTest {

    private fun testing(actual:String, expected:String) {
        assertEquals(expected, actual)
    }

    @Test
    fun test0() {
        println("Fixed Tests operArray : gcdi, lcmu, som, mini, maxi")
        val a = longArrayOf(18, 69, -90, -78, 65, 40)

        var r = longArrayOf(18, 3, 3, 3, 1, 1)
        testing(Arrays.toString(operArray(LongBinaryOperator({ x, y -> gcdi(x, y) }), a, a[0])),
                Arrays.toString(r))

        r = longArrayOf(18, 414, 2070, 26910, 26910, 107640)
        testing(Arrays.toString(operArray(LongBinaryOperator({ a, b -> lcmu(a, b) }), a, a[0])),
                Arrays.toString(r))

        r = longArrayOf(18, 87, -3, -81, -16, 24)
        testing(Arrays.toString(operArray(LongBinaryOperator({ a, b -> som(a, b) }), a, 0)),
                Arrays.toString(r))

        r = longArrayOf(18, 18, -90, -90, -90, -90)
        testing(Arrays.toString(operArray(LongBinaryOperator({ a, b -> mini(a, b) }), a, a[0])),
                Arrays.toString(r))

        r = longArrayOf(18, 69, 69, 69, 69, 69)
        testing(Arrays.toString(operArray(LongBinaryOperator({ a, b -> maxi(a, b) }), a, a[0])),
                Arrays.toString(r))
    }

}