package com.programapprentice.app;

import org.junit.Test;

import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/16/15
 * Time: 12:50 AM
 */
public class ThreeSum_Test {
    ThreeSum_15 obj = new ThreeSum_15();

    public void print(List<List<Integer>> list) {
        for(List<Integer> item : list) {
            for(Integer i : item) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }

    }
    @Test
    public void test1() {
        int[] num = {-1, 0, 1};
        List<List<Integer>> output = obj.threeSum_slow2(num);
        print(output);
    }
}
