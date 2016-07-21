package com.willmadison;

public class Kata {

    public static String getMiddle(String string) {
        int start = string.length() / 2, end;

        boolean isEven = string.length() % 2 == 0;

        if (isEven) {
            start--;
            end = start + 2;
        } else {
            end = start + 1;
        }

        return string.substring(start, end);
    }
}
