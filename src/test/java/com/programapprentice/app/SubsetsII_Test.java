package com.programapprentice.app;

import com.programapprentice.util.Util;
import org.junit.Test;

import java.util.List;

/**
 * User: program-apprentice
 * Date: 9/6/15
 * Time: 10:04 PM
 */
public class SubsetsII_Test {
    SubsetsII_90 obj = new SubsetsII_90();
    @Test
    public void test1() {
        int[] nums = {1, 1};
        List<List<Integer>> actual = obj.subsetsWithDup(nums);
        Util.printListOfListNumbers(actual);
    }

    @Test
    public void test2() {
        int[] nums = {1, 1, 2, 2};
        List<List<Integer>> actual = obj.subsetsWithDup(nums);
        Util.printListOfListNumbers(actual);
    }
}
