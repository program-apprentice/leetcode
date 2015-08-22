package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/21/15
 * Time: 7:07 PM
 */
public class Search2DMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        int low = 0;
        int high = height-1;
        int mid = 0;
        while(low <= high) { // wrong: while(low < high) {
            mid = (low + high) / 2;
            if(target < matrix[mid][0]) {
                high = mid-1;
            } else if (target > matrix[mid][width-1]) {
                low = mid + 1;
            } else {
                break;
            }
        }
        int line = mid;
        low = 0;
        high = width-1;
        while(low <= high) { // wrong: while(low < high) {
            mid = (low + high) / 2;
            if(target < matrix[line][mid]) {
                high = mid - 1;
            } else if (target > matrix[line][mid]) { // wrong: } else if (target < matrix[line][mid]) {
                low = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
