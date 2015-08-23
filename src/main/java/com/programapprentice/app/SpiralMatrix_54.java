package com.programapprentice.app;

import java.util.ArrayList;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/20/15
 * Time: 5:56 PM
 */
public class SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = 0;

        while(true) {
            for(int n = 0; n < col; n++) {
                list.add(matrix[i][j]);
                j++;
            }
            j--;
            row --;
            if(row == 0) {
                break;
            }

            i++;
            for(int n = 0; n < row; n++) {
                list.add(matrix[i][j]);
                i++;
            }
            i--;

            col--;
            if(col == 0) {
                break;
            }

            j--;
            for(int n = 0; n < col; n++ ) {
                list.add(matrix[i][j]);
                j--;
            }
            j++;

            row--;
            if(row == 0) {
                break;
            }

            i--;
            for(int n = 0; n < row; n++) {
                list.add(matrix[i][j]);
                i--;
            }
            i++;
            j = i;
            col--;
            if(col == 0) {
                break;
            }
        }

        return list;
    }
}
