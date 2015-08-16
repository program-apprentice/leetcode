package com.programapprentice.app;

import com.programapprentice.util.Util;
import org.junit.Test;

import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/16/15
 * Time: 2:24 PM
 */
public class FourSum_Test {
    FourSum_18 obj = new FourSum_18();
    @Test
    public void test1() {
        int[] num = {-2, -1, 0, 0, 1, 2};
        int target = 0;
        List<List<Integer>> actual = obj.fourSum(num, target);
        Util.printListOfListNumbers(actual);
    }

    @Test
    public void test2() {
        int[] num = {-3, -1, 0, 2, 4, 5};
        int target = 1;
        List<List<Integer>> actual = obj.fourSum(num, target);
        Util.printListOfListNumbers(actual);
    }

    @Test
    public void test3() {
        int[] num = {-1,-5,-5,-3,2,5,0,4};
        int target = -7;
        List<List<Integer>> actual = obj.fourSum(num, target);
        Util.printListOfListNumbers(actual);
    }

    @Test
    public void test4() {
        int[] num = {-1,0,-5,-2,-2,-4,0,1,-2};
        int target = -9;
        List<List<Integer>> actual = obj.fourSum(num, target);
        Util.printListOfListNumbers(actual);
    }

    @Test
    public void test5() {
        int[] num = {0, 0, 0, 0};
        int target = 0;
        List<List<Integer>> actual = obj.fourSum(num, target);
        Util.printListOfListNumbers(actual);
    }
}
