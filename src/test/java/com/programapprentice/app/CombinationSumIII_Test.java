package com.programapprentice.app;

import com.programapprentice.util.Util;
import org.junit.Test;

import java.util.List;

/**
 * User: program-apprentice
 * Date: 10/11/15
 * Time: 7:03 PM
 */
public class CombinationSumIII_Test {
    CombinationSumIII_216 obj = new CombinationSumIII_216();

    @Test
    public void test1() {
        int k = 3;
        int n = 7;
        List<List<Integer>> output = obj.combinationSum3(k, n);
        Util.printListOfListNumbers(output);
    }

    @Test
    public void test2() {
        int k = 3;
        int n = 9;
        List<List<Integer>> output = obj.combinationSum3(k, n);
        Util.printListOfListNumbers(output);
    }

    @Test
    public void test3() {
        int k = 2;
        int n = 18;
        List<List<Integer>> output = obj.combinationSum3(k, n);
        Util.printListOfListNumbers(output);
    }
}
