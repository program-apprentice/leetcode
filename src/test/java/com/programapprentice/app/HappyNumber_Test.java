package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 8/13/15
 * Time: 11:41 PM
 */
public class HappyNumber_Test {
    HappyNumber_202 obj = new HappyNumber_202();

    @Test
    public void test1() {
        int n = 2;
        boolean expected = false;
        boolean actual = obj.isHappy(n);
        assertEquals(expected, actual);
    }
}
