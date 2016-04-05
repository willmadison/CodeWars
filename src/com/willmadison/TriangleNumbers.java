/*
 * $Id$
 * $HeadURL$
 */
package com.willmadison;

public class TriangleNumbers {

    public static Boolean isTriangleNumber(long number) {
        long discriminant = 1 + 8 * number;
        long root = (long) Math.sqrt(discriminant);

        boolean triangleNumber = false;

        boolean isPerfectSquare = (root * root) == discriminant;

        if (isPerfectSquare) {
            triangleNumber = (-1 + root) >= 0;
        }

        return triangleNumber;
    }

    public static void main(String args[]) {
        System.out.println(TriangleNumbers.isTriangleNumber(0));
        System.out.println(TriangleNumbers.isTriangleNumber(3));
        System.out.println(TriangleNumbers.isTriangleNumber(4));
        System.out.println(TriangleNumbers.isTriangleNumber(64));
        System.out.println(TriangleNumbers.isTriangleNumber(21));
        System.out.println(TriangleNumbers.isTriangleNumber(312537501));
    }

}
