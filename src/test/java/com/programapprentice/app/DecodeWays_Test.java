package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 8/23/15
 * Time: 3:42 PM
 */
public class DecodeWays_Test {
    DecodeWays_91 obj = new DecodeWays_91();
    @Test
    public void test1() {
        String s = "10";
        int expected= 1;
        int actual = obj.numDecodings(s);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String s = "9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253";
        int expected= 3981312;
        int actual = obj.numDecodings(s);
        assertEquals(expected, actual);
    }
}
