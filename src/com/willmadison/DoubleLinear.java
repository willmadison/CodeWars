/*
 * $Id$
 * $HeadURL$
 */
package com.willmadison;

import java.util.SortedSet;
import java.util.TreeSet;

class DoubleLinear {
    public static int dblLinear(int n) {
        SortedSet<Integer> u = new TreeSet<>();
        u.add(1);

        for (int i = 0; i < n; i++) {
            int x = u.first();
            u.add(x * 2 + 1);
            u.add(x * 3 + 1);
            u.remove(x);
        }

        return u.first();
    }

    public static void main(String args[]) {
        System.out.println(DoubleLinear.dblLinear(10) == 22);
        System.out.println(DoubleLinear.dblLinear(20) == 57);
        System.out.println(DoubleLinear.dblLinear(30) == 91);
        System.out.println(DoubleLinear.dblLinear(50) == 175);
    }
}