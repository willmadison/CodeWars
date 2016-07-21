package com.willmadison;

import org.junit.Test;

import static org.junit.Assert.*;

public class AreSameTest {

    @Test
    public void emptyArraysAreTheSame() {
        assertTrue(AreSame.comp(new int[]{}, new int[]{}));
    }

    @Test
    public void differentSizedListAreNotTheSame() {
        assertFalse(AreSame.comp(new int[]{1,2,3}, new int[]{1,2}));
    }

}