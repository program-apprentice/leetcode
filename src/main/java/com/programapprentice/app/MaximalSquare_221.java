package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 10/6/15
 * Time: 7:30 PM
 */
public class MaximalSquare_221 {
    public boolean isSame(int a, int b, int c) {
        return a == b && b == c;
    }

    public int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public int min3(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public int max(int[][] matrix) {
        int m = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                m = m > matrix[i][j] ? m : matrix[i][j];
            }
        }
        return m;
    }
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] record = new int[height][width];
        if(matrix[0][0] == '1') {
            record[0][0] = 1;
        }
        for(int i = 1; i <  width; i++) {
            if(matrix[0][i] == '1') {
                record[0][i] = 1;
            }
        }

        for(int i = 1; i <  height; i++) {
            if(matrix[i][0] == '1') {
                record[i][0] = 1;
            }
        }

        int m = 0;

        for(int row = 1; row < height; row++) {
            for(int col = 1; col < width; col++) {
                if(matrix[row][col] == '0') {
                    record[row][col] = 0;
                } else {
                    record[row][col] = min3(record[row-1][col-1], record[row-1][col], record[row][col-1]) + 1;
                    m = m > record[row][col] ? record[row][col] : m;
                }
            }
        }
        return m * m;
    }
}
