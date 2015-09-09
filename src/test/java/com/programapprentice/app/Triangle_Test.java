package com.programapprentice.app;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 9/8/15
 * Time: 10:13 PM
 */
public class Triangle_Test {
    Triangle_120 obj = new Triangle_120();

    @Test
    public void test1() {
        List<List<Integer>> input = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        item.add(-1);
        input.add(item);
        item = new ArrayList<Integer>();
        item.add(-2);
        item.add(-3);
        input.add(item);
        int expected = -4;
        int actual = obj.minimumTotal(input);
        assertEquals(expected, actual);
    }
}
