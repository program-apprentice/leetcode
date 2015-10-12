package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 10/11/15
 * Time: 5:10 PM
 */
public class SearchA2DMatrixII_Test {
    SearchA2DMatrixII_240 obj = new SearchA2DMatrixII_240();
    @Test
    public void test1() {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        };
        int target = 5;
        boolean actual = obj.searchMatrix(matrix, target);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        };
        int target = 20;
        boolean actual = obj.searchMatrix(matrix, target);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] input = {1, 4, 7, 11, 15};
        int target = 5;
        boolean expected = false;
        boolean actual = obj.bstSearch(input, target);
        assertEquals(expected, actual);
    }
}
