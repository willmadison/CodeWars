/*
 * $Id$
 * $HeadURL$
 */
package com.willmadison;

/**
 * TODO: Enter class description....
 *
 * @author Will Madison (wmadisonDev@GMail.com)
 * @version $Revision$, $LastChangedDate$
 */
public class Evaporator {

    public static int evaporator(double content, double dailyPercentageLoss, double threshold) {
        int viability = 0;

        double endOfLife = content * threshold / 100.0;

        do {
            viability++;

            content -= content * dailyPercentageLoss / 100.0;
        } while (content > endOfLife);

        return viability;
    }
}