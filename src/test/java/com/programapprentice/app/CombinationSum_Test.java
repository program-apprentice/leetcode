package com.programapprentice.app;

import com.programapprentice.util.Util;
import org.junit.Test;

import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/17/15
 * Time: 10:37 PM
 */
public class CombinationSum_Test {
    CombinationSum_39 obj = new CombinationSum_39();
    @Test
    public void test1() {
        int[] nums = {11,5,12,7,9,8};
        int target = 17;
        List<List<Integer>> actual = obj.combinationSum(nums, target);
        Util.printListOfListNumbers(actual);
    }

    @Test
    public void test2() {
        int[] nums = {2,3,6,7};
        int target = 7;
        List<List<Integer>> actual = obj.combinationSum(nums, target);
        Util.printListOfListNumbers(actual);
    }
}
