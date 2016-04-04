package com.willmadison;

import java.util.*;

public class Consecutives {

    public static List<Integer> sumConsecutives(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        for (Integer number : numbers) {
            if (stack.isEmpty()) {
                stack.push(number);
            } else {
                if (number.equals(stack.peek())) {
                    stack.push(number);
                } else {
                    int sumOfElements = 0;

                    do {
                        Integer element = stack.pop();
                        sumOfElements += element;
                    } while (!stack.isEmpty());

                    result.add(sumOfElements);
                    stack.push(number);
                }
            }
        }

        if (!stack.isEmpty()) {
            int sumOfElements = 0;

            do {
                Integer element = stack.pop();
                sumOfElements += element;
            } while (!stack.isEmpty());

            result.add(sumOfElements);
        }

        return result;
    }

    public static void main(String args[]) {
        System.out.println(Consecutives.sumConsecutives(Arrays.asList(1,4,4,4,0,4,3,3,1)));
    }
}
