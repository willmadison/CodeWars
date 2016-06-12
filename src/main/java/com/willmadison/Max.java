package com.willmadison;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Max {
    public static int sequence(int[] array) {
        int maxSum = 0;

        boolean seenNegative = false;
        boolean seenPositive = false;

        int sumTotal = 0;

        List<Integer> asList = new ArrayList<>();

        for (int i : array) {
            if (i < 0) {
                seenNegative = true;
            } else if (i >= 0) {
                seenPositive = true;
            }

            sumTotal += i;
            asList.add(i);
        }

        boolean allNegatives = seenNegative && !seenPositive;
        boolean allPositives = seenPositive && !seenNegative;

        if (allPositives) {
            maxSum = sumTotal;
        } else if (!allNegatives) {
            Collection<Collection<Integer>> subsets = new ArrayList<>();

            for (int from = 0; from < array.length; ++from) {
                for (int to = from + 1; to <= array.length; ++to) {
                    subsets.add(asList.subList(from, to));
                }
            }

            maxSum = findMaxSubset(subsets);
        }

        return maxSum;
    }

    private static int findMaxSubset(Collection<Collection<Integer>> subsets) {
        int maxSum = 0;

        for (Collection<Integer> subset : subsets) {
            int sum = subset.stream().reduce(0, (a, b) -> a + b);

            if (sum >= maxSum) {
                maxSum = sum;
            }
        }

        return maxSum;
    }

    public static void main(String args[]) {
        System.out.println(Max.sequence(new int[]{}));
        System.out.println(Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}