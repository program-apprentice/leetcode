package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/8/15
 * Time: 9:06 PM
 */
public class ValidSudoku_36 {
    public boolean isValid(char[] input) {
        boolean[] record = new boolean[10];
        for(int i = 0; i < 9; i++) {
            if(input[i] == '.') {
                continue;
            }
            if(record[input[i] - '0']) {
                return false;
            } else {
                record[input[i] - '0'] = true;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        // check row
        for(int row = 0; row < 9; row++) {
            char[] cell = new char[9];
            for(int col = 0; col < 9; col++) {
                cell[col] = board[row][col];
            }
            if(!isValid(cell)) {
                return false;
            }
        }

        // check col
        for(int col = 0; col < 9; col++) {
            char[] cell = new char[9];
            for(int row = 0; row < 9; row++) {
                cell[row] = board[row][col];
            }
            if(!isValid(cell)) {
                return false;
            }
        }

        // check cell
        for(int crow = 0; crow < 3; crow++) {
            for(int ccol = 0; ccol < 3; ccol++) {
                char[] cell = new char[9];
                for(int i = 0; i < 9; i++) {
                    cell[i] = board[crow*3 + i / 3][ccol*3 + i % 3];
                }
                if(!isValid(cell)) {
                    return false;
                }
            }
        }
        return true;
    }
}
