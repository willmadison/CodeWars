/*
 * $Id$
 * $HeadURL$
 */
package com.willmadison.ordering;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.regex.Pattern;

public class Order {

    public static final Collection<Character> digits = new LinkedHashSet<>();

    static {
        for (int i = 1; i < 10; i++) {
            digits.add(Character.forDigit(i, 10));
        }
    }

    public static String order(String sentence) {
        String output = "";

        if (!isEmpty(sentence)) {
            Map<Character, String> wordByDigitContained = new HashMap<>();

            String trimmed = sentence.trim();

            String[] words = trimmed.split(Pattern.quote(" "));

            for (String word : words) {
                for (char character : word.toCharArray()) {
                    if (digits.contains(character)) {
                        wordByDigitContained.put(character, word);
                        break;
                    }
                }
            }

            StringBuilder sentenceSb = new StringBuilder();

            for (Character c : digits) {
                String word = wordByDigitContained.get(c);

                if (word != null) {
                    sentenceSb.append(word).append(" ");
                }
            }

            output = sentenceSb.toString().trim();
        }

        return output;
    }

    private static boolean isEmpty(String value) {
        return value == null || "".equals(value.trim());
    }
}