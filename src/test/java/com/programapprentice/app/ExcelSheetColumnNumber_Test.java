package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 8/13/15
 * Time: 6:53 PM
 */
public class ExcelSheetColumnNumber_Test {
    ExcelSheetColumnNumber_171 obj = new ExcelSheetColumnNumber_171();
    @Test
    public void test1() {
        String input = "AA";
        int expected = 27;
        int actual = obj.titleToNumber(input);
        assertEquals(expected, actual);
    }

}
