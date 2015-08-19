package com.programapprentice.app;

import com.programapprentice.util.Util;
import org.junit.Test;

import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/18/15
 * Time: 7:53 PM
 */
public class CombinationSumII_Test {
    CombinationSumII_40 obj = new CombinationSumII_40();
    @Test
    public void Test1() {
        int[] nums= {1, 1};
        int target = 2;
        List<List<Integer>> actual = obj.combinationSum2(nums, target);
        Util.printListOfListNumbers(actual);
    }

    @Test
    public void Test2() {
        int[] nums= {1, 1};
        int target = 1;
        List<List<Integer>> actual = obj.combinationSum2(nums, target);
        Util.printListOfListNumbers(actual);
    }
}
