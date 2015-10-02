package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 10/1/15
 * Time: 8:45 PM
 */
public class CourseSchedule_Test {
    CourseSchedule_207 obj = new CourseSchedule_207();
    @Test
    public void test1() {
        int[][] input = { {1, 0}, {0, 1}};
        int num = 2;
        boolean expected = false;
        boolean actual = obj.canFinish(num, input);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[][] input = { {1, 0}};
        int num = 2;
        boolean expected = false;
        boolean actual = obj.canFinish(num, input);
        assertEquals(expected, actual);
    }
}
