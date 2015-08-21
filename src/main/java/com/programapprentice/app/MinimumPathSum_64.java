package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/20/15
 * Time: 5:55 PM
 */
public class MinimumPathSum_64 {
    // grid only contains non-negative
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {

        }
        int nRows = grid.length;
        int nCols = grid[0].length;
        int[][] rec = new int[nRows][nCols];
        rec[0][0] = grid[0][0];

        for(int i = 1; i < nCols; i++) {
            rec[0][i] = grid[0][i] + rec[0][i-1];
        }

        for(int i = 1; i < nRows; i++) {
            rec[i][0] = grid[i][0] + rec[i-1][0];
        }

        for(int i = 1; i < nRows; i++) {
            for(int j = 1; j < nCols; j++) {
                rec[i][j] = grid[i][j] + Math.min(rec[i][j-1], rec[i-1][j]);
            }
        }
        return rec[nRows-1][nCols-1];
    }

}
