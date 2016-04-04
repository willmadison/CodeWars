/*
 * $Id$
 * $HeadURL$
 */
package com.willmadison;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Persist {

    public static int persistence(long number) {
        int multiplicativePersistence = 0;
        boolean isSingleDigit = number < 10;

        if (!isSingleDigit) {
            int numDigitsInProduct = Integer.MAX_VALUE;

            do {
                String numberAsString = Long.toString(number);
                Collection<Long> digits = convert(Arrays.asList(numberAsString.split("")));

                number = multiply(digits);

                numberAsString = Long.toString(number);
                digits = convert(Arrays.asList(numberAsString.split("")));

                ++multiplicativePersistence;

                numDigitsInProduct = digits.size();
            } while (numDigitsInProduct > 1);
        }

        return multiplicativePersistence;
    }

    private static Collection<Long> convert(Collection<String> digits) {
        return digits.stream().map(Long::parseLong).collect(Collectors.toList());
    }

    private static long multiply(Collection<Long> numbers) {
        return numbers.stream().reduce(1L, (a, b) -> a * b);
    }
}
