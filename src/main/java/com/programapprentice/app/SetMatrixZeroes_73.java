package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/9/15
 * Time: 9:30 PM
 */
public class SetMatrixZeroes_73 {

    /** Brute force:
     * have a vector store which row or column need to be as zero
     */
    public void setZeroes_bruteforce(int[][] matrix) {
        if(matrix == null) {
            return;
        }
        int height = matrix.length;
        if(height == 0) {
            return;
        }
        int width = matrix[0].length;
        if(width == 0) {
            return;
        }
        boolean[] rowVector = new boolean[height];
        boolean[] colVector = new boolean[width];
        for(int i = 0; i < height; i ++) {
            for(int j = 0; j < width; j++) {
                if(matrix[i][j] == 0) {
                    rowVector[i] = true;
                    colVector[j] = true;
                }
            }
        }
        for(int i = 0; i < height; i ++) {
            for (int j = 0; j < width; j++) {
                if(rowVector[i]|| colVector[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        if(matrix == null) {
            return;
        }
        int height = matrix.length;
        if(height == 0) {
            return;
        }
        int width = matrix[0].length;
        if(width == 0) {
            return;
        }
        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;
        for(int i = 0; i < width; i++) {
            if(matrix[0][i] == 0) {
                isFirstRowZero = true;
                break;
            }
        }

        for(int i = 0; i < height; i++) {
            if(matrix[i][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }

        for(int i = 1; i < height; i++) {
            for(int j = 1; j < width; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < height; i++) {
            for(int j = 1; j < width; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(isFirstColZero) {
            for(int i = 0; i < height; i++) {
                matrix[i][0] = 0;
            }
        }

        if(isFirstRowZero) {
            for(int i = 0; i < width; i++) {
                matrix[0][i] = 0;
            }
        }

    }
}
