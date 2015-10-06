package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 10/5/15
 * Time: 7:54 PM
 */
public class HouseRobberII_Test {
    HouseRobberII_213 obj = new HouseRobberII_213();
    @Test
    public void test1() {
        int[] input = {2, 1, 1, 1};
        int expected = 3;
        int actual = obj.rob(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] input = {1,1,3,6,7,10,7,1,8,5,9,1,4,4,3};
        int expected = 41;
        int actual = obj.rob(input);
        assertEquals(expected, actual);
    }
}
