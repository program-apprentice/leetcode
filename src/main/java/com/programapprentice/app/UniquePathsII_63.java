package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/20/15
 * Time: 5:55 PM
 */
public class UniquePathsII_63 {

    public int uniquePathsWithObstacles(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int[][] rec = new int[numRows][numCols];
        boolean metObstacle = false;
        for(int i = 0; i < numCols; i++) {
            if(metObstacle) {
                rec[0][i] = 0;
            } else {
                if(matrix[0][i] == 1) {
                    metObstacle = true;
                    rec[0][i] = 0;
                } else {
                    rec[0][i] = 1;
                }
            }
        }

        metObstacle = false;
        for(int i = 0; i < numRows; i++) {
            if(metObstacle) {
                rec[i][0] = 0;
            } else {
                if(matrix[i][0] == 1) {
                    metObstacle = true;
                    rec[i][0] = 0;
                } else {
                    rec[i][0] = 1;
                }
            }
        }

        for(int i = 1; i < numRows; i++) {
            for(int j = 1; j < numCols; j++) {
                if(matrix[i][j] == 1) {
                    rec[i][j] = 0;
                } else {
                    rec[i][j] = rec[i][j-1] + rec[i-1][j];
                }
            }
        }
        return rec[numRows-1][numCols-1]; // wrong: matrix[numRows-1][numCols-1]
    }
}
