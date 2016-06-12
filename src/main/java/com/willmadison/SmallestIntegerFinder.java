/*
 * $Id$
 * $HeadURL$
 */
package com.willmadison;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class SmallestIntegerFinder {
    public static int findSmallestInt(int[] args) {
        Collection<Integer> numbers = new HashSet<>();

        for (int number : args) {
            numbers.add(number);
        }

        return Collections.min(numbers);
    }
}
