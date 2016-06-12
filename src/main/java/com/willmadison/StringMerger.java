package com.willmadison;

import java.util.HashMap;
import java.util.Map;

public class StringMerger {


    @SuppressWarnings("Duplicates")
    public static boolean isMerge(String string, String part1, String part2) {
        Map<Character, Integer> sourceOccurrencesByCharacter = new HashMap<>();
        Map<Character, Integer> mergedOccurrencesByCharacter = new HashMap<>();

        sourceOccurrencesByCharacter.clear();

        boolean mergable = true;

        String merged = part1 + part2;

        for (Character character : string.toCharArray()) {
            if (!sourceOccurrencesByCharacter.containsKey(character)) {
                sourceOccurrencesByCharacter.put(character, 0);
            }

            Integer occurrences = sourceOccurrencesByCharacter.get(character);
            occurrences++;
            sourceOccurrencesByCharacter.put(character, occurrences);
        }

        for (Character character : merged.toCharArray()) {
            if (!mergedOccurrencesByCharacter.containsKey(character)) {
                mergedOccurrencesByCharacter.put(character, 0);
            }

            Integer occurrences = mergedOccurrencesByCharacter.get(character);
            occurrences++;
            mergedOccurrencesByCharacter.put(character, occurrences);
        }

        for (Map.Entry<Character, Integer> characterOccurrence : sourceOccurrencesByCharacter.entrySet()) {
            Character character = characterOccurrence.getKey();
            Integer occurrences = characterOccurrence.getValue();

            Integer occurrencesInMerge = mergedOccurrencesByCharacter.get(character);

            if (occurrencesInMerge == null || occurrencesInMerge < occurrences) {
                mergable = false;
                break;
            }
        }

        return mergable;
    }

    public static void main(String args[]) {
        System.out.println(StringMerger.isMerge("codewars", "code", "wars"));
        System.out.println(StringMerger.isMerge("codewars", "cdwr", "oeas"));
        System.out.println(StringMerger.isMerge("codewars", "cod", "wars"));
    }
}
