package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/19/15
 * Time: 4:51 PM
 */
public class SpiralMatrixII_59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int numSteps = n /2;
        int val = 1;
        for(int i = 0; i < numSteps; i++) {
            int sLen = n -  i - 1;

            // top left to top right
            for(int j = i; j < sLen; j++) {
                matrix[i][j] = val;
                val++;
            }

            // right top to right bottom
            for(int j = i; j < sLen; j++) {
                matrix[j][n-i-1] = val;
                val++;
            }

            // bottom right to bottom left
            for(int j = i; j < sLen; j++) {
                matrix[n-i-1][n-j-1] = val;
                val++;
            }

            // left bottom to left top
            for(int j = i; j < sLen; j++) {
                matrix[n-j-1][i] = val;
                val++;
            }
        }
        if(n%2 == 1) {
            matrix[numSteps][numSteps] = val; // wrong:matrix[numSteps+1][numSteps+1] = val;
        }
        return matrix;
    }
}