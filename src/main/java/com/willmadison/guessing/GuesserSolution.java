/*
 * $Id$
 * $HeadURL$
 */
package com.willmadison.guessing;

public class GuesserSolution extends Guesser {

    public int getNumber() {
        int min = 1, max = 1000, guess;

        boolean correct = false;

        do {
            guess = getMidpoint(min, max);

            String answer = guess(guess);

            boolean isHigh = answer.contains("high");
            boolean isLow = answer.contains("low");
            correct = answer.toLowerCase().contains("Correct");

            if (isHigh) {
                max = guess;
            } else if (isLow) {
                min = guess;
            }
        } while (!correct);

        return guess;
    }

    private int getMidpoint(int min, int max) {
        return (min + max) / 2;
    }
}
