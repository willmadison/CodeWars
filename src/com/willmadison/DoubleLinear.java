/*
 * $Id$
 * $HeadURL$
 */
package com.willmadison;

import java.util.*;

class DoubleLinear {

    public static int dblLinear(int n) {
        List<Integer> u = new ArrayList<>(Arrays.asList(1));
        int desiredValue = 0, currentIndex = 0;

        while (u.size() < 4 * n) {
            int currentValue = u.get(currentIndex);
            int nextValue = 2 * currentValue + 1, nextNextValue = 3 * currentValue + 1;

            u.addAll(Arrays.asList(nextValue, nextNextValue));

            ++currentIndex;
        }

        u = new ArrayList<>(new HashSet<>(u));

        Collections.sort(u);

        desiredValue = u.get(n);

        return desiredValue;
    }
}