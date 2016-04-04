package com.willmadison;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BraceChecker {

    private Stack<Character> stack = new Stack<>();

    private Map<Character, Character> openingBraceByClosingBrace = new HashMap<Character, Character>() {{
        put(')', '(');
        put(']', '[');
        put('}', '{');
    }};

    public boolean isValid(String braces) {
        stack.clear();

        try {
            for (Character character : braces.toCharArray()) {
                switch (character) {
                    case '(':
                    case '[':
                    case '{':
                        stack.push(character);
                        break;
                    case ')':
                    case ']':
                    case '}':
                        Character lastBrace = stack.peek();
                        Character openingBrace = openingBraceByClosingBrace.get(character);

                        if (lastBrace.equals(openingBrace)) {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                }

            }
        } catch (EmptyStackException ese) {
            return false;
        }

        return stack.isEmpty();
    }

    public static void main(String args[]) {
        BraceChecker checker = new BraceChecker();

        System.out.println(checker.isValid("[(])"));
    }
}
