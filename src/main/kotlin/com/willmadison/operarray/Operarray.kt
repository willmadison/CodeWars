package com.willmadison.operarray

import java.util.function.LongBinaryOperator

fun gcdi(xx: Long, yy: Long) = gcd(abs(xx), abs(yy))

fun lcmu(a: Long, b: Long) = lcm(abs(a), abs(b))

fun lcm(a: Long, b: Long) = a * b / gcd(a, b)

fun gcd(a: Long, b: Long): Long {
    if (b == 0L) {
        return a
    }

    return gcd(b, a % b)
}

fun abs(x: Long) = when {
    x < 0 -> -x
    else -> x
}

fun som(a: Long, b: Long) = a + b

fun maxi(a: Long, b: Long) = when {
    a > b -> a
    else -> b
}

fun mini(a: Long, b: Long) = when {
    a < b -> a
    else -> b
}

fun operArray(op: LongBinaryOperator, arr: LongArray, init: Long): LongArray {
    val r = LongArray(arr.size)

    for (i in arr.indices) {
        if (i == 0) {
            r[i] = op.applyAsLong(init, arr[i])
            continue
        }

        r[i] = op.applyAsLong(r[i - 1], arr[i])
    }

    return r
}