package com.willmadison;

import java.util.HashMap;
import java.util.Map;

public class FindOdd {
    public static int findIt(int[] numbers) {
        Map<Integer, Integer> occurrencesByNumber = new HashMap<>();

        for (Integer i : numbers) {
            if (!occurrencesByNumber.containsKey(i)) {
                occurrencesByNumber.put(i, 0);
            }

            Integer occurrences = occurrencesByNumber.get(i);
            ++occurrences;
            occurrencesByNumber.put(i, occurrences);
        }

        return findOddOccurrences(occurrencesByNumber);
    }

    private static int findOddOccurrences(Map<Integer, Integer> occurrencesByNumber) {
        int number = 0;

        for (Map.Entry<Integer, Integer> numberOccurrence : occurrencesByNumber.entrySet()) {
            number = numberOccurrence.getKey();
            int occurrences = numberOccurrence.getValue();

            if (occurrences % 2 != 0) {
                break;
            }
        }

        return number;
    }

    public static void main(String args[]) {
        System.out.println(FindOdd.findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
    }
}
