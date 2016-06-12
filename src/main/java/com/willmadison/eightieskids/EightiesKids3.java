/*
 * $Id$
 * $HeadURL$
 */
package com.willmadison.eightieskids;

import java.util.*;

/**
 * TODO: Enter class description....
 *
 * @author Will Madison (wmadisonDev@GMail.com)
 * @version $Revision$, $LastChangedDate$
 */
public class EightiesKids3 {

    public static String[] getSocks(String name, String[] socks) {
        SockPairSelector selector = new SockPairSelector();

        switch (name.toLowerCase()) {
            case "punky":
                selector.setStrategy(new PunkySelectionStrategy());
                break;
            case "henry":
                selector.setStrategy(new HenrySelectionStrategy());
                break;
        }

        Collection<String> selectedPair = selector.select(Arrays.asList(socks));

        return selectedPair.toArray(new String[selectedPair.size()]);
    }

    private interface SelectionStrategy {
        Collection<String> select(Collection<String> socks);

    }

    private static abstract class BaseSelectionStrategy implements SelectionStrategy {
        protected Map<String, Integer> occurrencesBySockColor = new HashMap<>();

        protected void preprocess(Collection<String> socks) {
            for (String sock : socks) {
                Integer numOccurrences = occurrencesBySockColor.get(sock);

                if (numOccurrences == null) {
                    numOccurrences = 0;
                }

                numOccurrences++;
                occurrencesBySockColor.put(sock, numOccurrences);
            }
        }

    }

    private static class PunkySelectionStrategy extends BaseSelectionStrategy {

        @Override
        public Collection<String> select(Collection<String> socks) {
            Collection<String> selectedPair = new HashSet<>();

            preprocess(socks);

            if (occurrencesBySockColor.size() > 1) {
               for (String sock : occurrencesBySockColor.keySet()) {
                   if (selectedPair.size() == 2) {
                       break;
                   }

                   selectedPair.add(sock);
               }
            }

            return selectedPair;
        }
    }

    private static class HenrySelectionStrategy extends BaseSelectionStrategy {

        @Override
        public Collection<String> select(Collection<String> socks) {
            Collection<String> selectedPair = new ArrayList<>();

            preprocess(socks);

            if (occurrencesBySockColor.size() >= 1) {
                for (Map.Entry<String, Integer> entry : occurrencesBySockColor.entrySet()) {
                    String sock = entry.getKey();
                    Integer occurences = entry.getValue();

                    if (occurences > 1) {
                        selectedPair.add(sock);
                        selectedPair.add(sock);
                        break;
                    }
                }
            }

            return selectedPair;
        }
    }

    private static class SockPairSelector {
        SelectionStrategy strategy;

        public Collection<String> select(Collection<String> socks) {
            if (strategy == null) {
                throw new IllegalStateException("No selection strategy provided cannot render selection!");
            }

            return strategy.select(socks);
        }

        public void setStrategy(SelectionStrategy strategy) {
            this.strategy = strategy;
        }
    }

}
