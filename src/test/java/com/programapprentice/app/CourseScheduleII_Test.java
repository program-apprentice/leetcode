package com.programapprentice.app;

import org.junit.Test;


/**
 * User: program-apprentice
 * Date: 10/1/15
 * Time: 10:20 PM
 */
public class CourseScheduleII_Test {
    CourseScheduleII_210 obj = new CourseScheduleII_210();
    @Test
    public void test1() {
        int[][] input = { {1, 0}, {0, 1}};
        int num = 2;
        int[] output = obj.findOrder(num, input);
    }

    @Test
    public void test2() {
        int[][] input = { {1, 0}};
        int num = 2;
        int[] output = obj.findOrder(num, input);
        System.out.println(output.length);
    }
}
