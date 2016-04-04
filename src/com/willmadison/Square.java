/*
 * $Id$
 * $HeadURL$
 */
package com.willmadison;

import java.util.regex.Pattern;

public class Square {
    public static boolean isSquare(int n) {
        double root = Math.sqrt(n);

        String rootAsString = Double.toString(root);

        String[] rootParts = rootAsString.split(Pattern.quote("."));

        return !rootAsString.equals("NaN") && rootParts[1].equalsIgnoreCase("0");
    }
}