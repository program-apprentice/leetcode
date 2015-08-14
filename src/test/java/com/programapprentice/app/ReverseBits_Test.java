package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 8/13/15
 * Time: 10:01 PM
 */
public class ReverseBits_Test {
    ReverseBits_190 obj = new ReverseBits_190();

    @Test
    public void test1() {
        int n = 43261596;
        System.out.println("input is " + Integer.toBinaryString(n));
        int expected = 964176192;
        int actual = obj.reverseBits(n);
        System.out.println("output is " + Integer.toBinaryString(actual));
        assertEquals(expected, actual);
    }
}
