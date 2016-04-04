package com.willmadison;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FrogJumping {

    public static int solution(int[] a) {
        System.out.println(Arrays.toString(a));
        int numJumps = 0;

        boolean inPond;

        int currentIndex = 0;

        int jumpVector;

        Set<Integer> visited = new HashSet<>();

        do {
            jumpVector = a[currentIndex];

            if (!visited.contains(currentIndex)) {
                visited.add(currentIndex);
                currentIndex += jumpVector;

                numJumps++;
                inPond = 0 <= currentIndex && currentIndex < a.length;
            } else {
                // We're in a cycle and can't escape.
                return -1;
            }
        } while (inPond);

        return numJumps;
    }

    public static void main(String args[]) {
        System.out.println(FrogJumping.solution(new int[]{1, 2, 1, 5}));
    }
}
