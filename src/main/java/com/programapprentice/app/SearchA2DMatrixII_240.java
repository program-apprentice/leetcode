package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 10/11/15
 * Time: 3:58 PM
 */
public class SearchA2DMatrixII_240 {
    public boolean bstSearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while(low <= high) {
            mid = (low + high) / 2;
            if(nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int rowLow, int rowHigh, int target) {
        if(rowLow > rowHigh) {
            return false;
        }
        int low = rowLow;
        int high = rowHigh;
        int mid = 0;
        boolean rowSearch = false;
        mid = (low + high) / 2;
        rowSearch = bstSearch(matrix[mid], target);
        if(rowSearch) {
            return true;
        }
        if(rowLow == rowHigh) {
            return rowSearch;
        }
        boolean upSearch = searchMatrix(matrix, rowLow, mid-1, target);
        boolean downSearch = searchMatrix(matrix, mid+1, rowHigh, target);
        return upSearch || downSearch;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return searchMatrix(matrix, 0, matrix.length-1, target);
    }
}
