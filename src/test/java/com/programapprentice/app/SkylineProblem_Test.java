package com.programapprentice.app;

import com.programapprentice.util.Util;
import org.junit.Test;

import java.util.List;

/**
 * User: program-apprentice
 * Date: 10/14/15
 * Time: 11:21 PM
 */
public class SkylineProblem_Test {
    SkylineProblem_218 obj = new SkylineProblem_218();
    @Test
    public void test1() {
        int[][] buildings = { {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8} };
        List<int[]> output = obj.getSkyline(buildings);
        Util.printListOfArrayNumbers(output);
    }
}
