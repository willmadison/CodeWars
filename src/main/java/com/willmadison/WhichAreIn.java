/*
 * $Id$
 * $HeadURL$
 */
package com.willmadison;

import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

public class WhichAreIn {

    public static String[] inArray(String[] candidates, String[] sources) {
        Collection<String> substrings = new TreeSet<>();

        for (String candidate : candidates) {
            for (String source : sources) {
                if (source.contains(candidate)) {
                    substrings.add(candidate);
                    break;
                }
            }
        }

        return substrings.toArray(new String[substrings.size()]);
    }

    public static void main(String args[]) {
        String a[] = new String[]{"arp", "live", "strong"};
        String b[] = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};
        String r[] = new String[]{"arp", "live", "strong"};
        System.out.println(Arrays.toString(WhichAreIn.inArray(a, b)));
    }
}
