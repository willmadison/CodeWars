package com.willmadison;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;
import java.util.regex.Pattern;

public class SpinWords {

    public String spinWords(String sentence) {
        String[] words = sentence.split(Pattern.quote(" "));
        Collection<String> reversedWords = new ArrayList<>();

        for (String word : words) {
            if (word.length() > 4) {
                word = reverse(word);
            }

            reversedWords.add(word);
        }

        return String.join(" ", reversedWords);
    }

    private String reverse(String word) {
        String[] characters = word.split("");

        Stack<String> stack = new Stack<>();

        for (String character : characters) {
            stack.push(character);
        }

        StringBuilder sb = new StringBuilder();

        do {
            sb.append(stack.pop());
        } while (!stack.isEmpty());

        return sb.toString();
    }
}
