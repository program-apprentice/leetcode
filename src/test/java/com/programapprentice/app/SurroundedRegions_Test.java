package com.programapprentice.app;

import com.programapprentice.util.Util;
import org.junit.Test;

/**
 * User: program-apprentice
 * Date: 9/9/15
 * Time: 11:38 PM
 */
public class SurroundedRegions_Test {
    SurroundedRegions_130 obj = new SurroundedRegions_130();
    @Test
    public void test1() {
        String[] input = {"OXXOX","XOOXO","XOXOX","OXOOO","XXOXO"};
        char[][] board = Util.convertStringsToCharArray(input);
        obj.solve(board);
    }
}
