/*
 * $Id$
 * $HeadURL$
 */
package com.willmadison.eightieskids;

public class EightiesKids5 {

    public static String bucketOf(String phrase) {
        boolean containsWateringStatement = detectWateringStatement(phrase);
        boolean containsSlimingStatement = detectSlimingStatement(phrase);

        String substanceInBucket = "air";

        if (containsWateringStatement && containsSlimingStatement) {
            substanceInBucket = "sludge";
        } else if (containsWateringStatement) {
            substanceInBucket = "water";
        } else if (containsSlimingStatement) {
            substanceInBucket = "slime";
        }

        return substanceInBucket;
    }

    private static boolean detectWateringStatement(String phrase) {
        return phrase.matches("(?i).*(water|wet|wash).*");
    }

    private static boolean detectSlimingStatement(String phrase) {
        return phrase.matches("(?i).*(slime|I\\s+don't\\s+know).*");
    }
}

