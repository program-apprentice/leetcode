package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 10/6/15
 * Time: 9:22 PM
 */
public class MaximalSquare_Test {
    MaximalSquare_221 obj = new MaximalSquare_221();
    @Test
    public void test1() {
        char[][] input = { {'1', '1'}, {'1', '1'}};
        int expected = 4;
        int actual = obj.maximalSquare(input);
        assertEquals(expected, actual);
    }
}
