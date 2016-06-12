/*
 * $Id$
 * $HeadURL$
 */
package com.willmadison;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Line {

    private static final Integer TICKET_PRICE = 25;

    private static final String YES = "YES";
    private static final String NO = "NO";


    public static String Tickets(int[] patrons) {
        int registerContents = 0;

        Map<Integer, Integer> occurencesByDenomination = new HashMap<>();

        for (int i : Arrays.asList(25, 50, 100)) {
            occurencesByDenomination.put(i, 0);
        }

        for (int amountRemitted : patrons) {
            if (amountRemitted >= 25) {
                boolean changeDue = amountRemitted > TICKET_PRICE;

                if (changeDue) {
                    int amountOfChangeDue = amountRemitted - TICKET_PRICE;

                    boolean hasEnoughForChange = registerContents >= amountOfChangeDue;

                    if (hasEnoughForChange) {
                        boolean hasEnoughSmallBills = false;

                        switch (amountOfChangeDue) {
                            case 25:
                                int num25s = occurencesByDenomination.get(25);
                                hasEnoughSmallBills = num25s > 0;

                                if (hasEnoughSmallBills) {
                                    int occurrences = occurencesByDenomination.get(25);
                                    occurrences--;
                                    occurencesByDenomination.put(25, occurrences);
                                }

                                break;
                            case 75:
                                num25s = occurencesByDenomination.get(25);
                                int num50s = occurencesByDenomination.get(50);
                                hasEnoughSmallBills = num25s > 0 && num50s > 0;

                                if (hasEnoughSmallBills) {
                                    int occurrences = occurencesByDenomination.get(25);
                                    occurrences--;
                                    occurencesByDenomination.put(25, occurrences);

                                    occurrences = occurencesByDenomination.get(50);
                                    occurrences--;
                                    occurencesByDenomination.put(50, occurrences);
                                }

                                break;
                        }

                        if (hasEnoughSmallBills) {
                            registerContents += amountRemitted;
                            registerContents -= amountOfChangeDue;

                            int occurrences = occurencesByDenomination.get(amountRemitted);
                            occurrences++;
                            occurencesByDenomination.put(amountRemitted, occurrences);
                        } else {
                            return NO;
                        }
                    } else {
                        return NO;
                    }
                } else {
                    registerContents += amountRemitted;
                    int occurrences = occurencesByDenomination.get(amountRemitted);
                    occurrences++;
                    occurencesByDenomination.put(amountRemitted, occurrences);
                }
            } else {
                return NO;
            }
        }

        return YES;
    }
}
