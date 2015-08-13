package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 8/12/15
 * Time: 10:42 PM
 */
public class CompareVersionNumbers_Test {
    CompareVersionNumbers_165 obj = new CompareVersionNumbers_165();

    @Test
    public void test1() {
        String version1 = "1";
        String version2 = "1.0";
        int expected = 0;
        int actual = obj.compareVersion(version1, version2);
        assertEquals(expected, actual);
    }
}
