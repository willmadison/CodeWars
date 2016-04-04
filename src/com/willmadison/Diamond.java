package com.willmadison;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Diamond {

    private static final String ASTERISK = "*";

    public static String print(int numAsterisksInMiddle) {
        String output = null;

        boolean isEven = numAsterisksInMiddle % 2 == 0;

        if (!isEven) {
            List<String> rows = new ArrayList<>();

            int numAsterisks = numAsterisksInMiddle;
            int padding = 0;

            while (numAsterisks > 0) {
                String row = getAsterisks(numAsterisks, padding);

                if (!rows.isEmpty()) {
                    rows.add(0, row);
                    rows.add(row);
                } else {
                    rows.add(row);
                }

                numAsterisks -= 2;
                ++padding;
            }

            StringJoiner joiner = new StringJoiner("\n");

            for (String row : rows) {
                joiner.add(row);
            }

            output = joiner.toString();
        }

        return output;
    }

    private static String getAsterisks(int numAsterisks, int padding) {
        StringBuilder asterisksSb = new StringBuilder();

        for (int i = 0; i < padding; i++) {
            asterisksSb.append(" ");
        }

        for (int i = 0; i < numAsterisks; ++i) {
            asterisksSb.append(ASTERISK);
        }

        return asterisksSb.toString();
    }

    public static void main(String args[]) {
        System.out.println(Diamond.print(5));
        System.out.println("##############################################");
        System.out.println(Diamond.print(2));
        System.out.println("##############################################");
        System.out.println(Diamond.print(7));
        System.out.println("##############################################");
        System.out.println(Diamond.print(3));
        System.out.println("##############################################");
    }
}
