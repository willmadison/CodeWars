package com.willmadison;

import java.util.*;
import java.util.regex.Pattern;

public class WeightSort {

    public static String orderWeight(String string) {
        List<WeightTuple> weightTuples = parse(string);

        Collections.sort(weightTuples, (firstTuple, secondTuple) -> {
            int difference = firstTuple.getScore() - secondTuple.getScore();

            if (difference == 0) {
                difference = firstTuple.getWeight().compareTo(secondTuple.getWeight());
            }

            return difference;
        });

        StringJoiner joiner = new StringJoiner(" ");

        for (WeightTuple tuple : weightTuples) {
            joiner.add(tuple.getWeight());
        }


        return joiner.toString();
    }

    private static List<WeightTuple> parse(String string) {
        List<WeightTuple> tuples = new ArrayList<>();

        String[] weights = string.split(Pattern.quote(" "));

        for (String weight : weights) {
            tuples.add(WeightTuple.fromWeight(weight));
        }

        return tuples;
    }

    private static class WeightTuple {
        private String weight;
        private int score;

        WeightTuple(String weight, int score) {
            this.weight = weight;
            this.score = score;
        }

        String getWeight() {
            return weight;
        }

        int getScore() {
            return score;
        }

        static WeightTuple fromWeight(String weight) {
            int score = calculateScore(weight);

            return new WeightTuple(weight, score);
        }

        private static int calculateScore(String weight) {
            int score = 0;

            String[] digits = weight.split(Pattern.quote(""));

            for (String digit : digits) {
                score += Integer.parseInt(digit);
            }

            return score;
        }

        @Override
        public String toString() {
            return "WeightTuple{" +
                    "weight='" + weight + '\'' +
                    ", score=" + score +
                    '}';
        }
    }

    public static void main(String args[]) {
        System.out.println(WeightSort.orderWeight("103 123 4444 99 2000"));
        System.out.println(WeightSort.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }
}
