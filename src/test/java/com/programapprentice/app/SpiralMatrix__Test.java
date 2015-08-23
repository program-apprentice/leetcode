package com.programapprentice.app;

import com.programapprentice.util.Util;
import org.junit.Test;

import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/22/15
 * Time: 10:01 PM
 */
public class SpiralMatrix__Test {
    SpiralMatrix_54 obj = new SpiralMatrix_54();

    @Test
    public void test1() {
        int[][] grid = {{1,2}};
        List<Integer> actual = obj.spiralOrder(grid);
        Util.printListInteger(actual);
    }

    @Test
    public void test2() {
        int[][] grid = {{1}, {2}};
        List<Integer> actual = obj.spiralOrder(grid);
        Util.printListInteger(actual);
    }

    @Test
    public void test3() {
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> actual = obj.spiralOrder(grid);
        Util.printListInteger(actual);
    }
}
