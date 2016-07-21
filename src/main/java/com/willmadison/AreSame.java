/*
 * $Id$
 * $HeadURL$
 */
package com.willmadison;

import java.util.Collection;
import java.util.HashSet;

public class AreSame {

    public static boolean comp(int[] a, int[] b) {
        boolean same = false;

        Collection<Integer> valuesInA = new HashSet<>();
        Collection<Integer> valuesInB = new HashSet<>();

        for (int value : a) {
            valuesInA.add(value);
        }

        for (int value : b) {
            valuesInB.add(value);
        }

        if (valuesInA.size() == valuesInB.size()) {
            same = true;
            for (int value : valuesInA) {
                if (!valuesInB.contains(value * value)) {
                    same = false;
                    break;
                }
            }
        }

        return same;
    }
}
