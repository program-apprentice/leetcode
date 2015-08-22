package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/21/15
 * Time: 6:42 PM
 */
public class WordSearch_79 {
    public boolean exist(char[][] board, int m, int n, String word, int start, boolean[][] rec) {
        if (m == board.length || n == board[0].length || m < 0 || n < 0 || word == null || word.isEmpty()) {
            return false;
        }
        if(rec[m][n]) {
            return false;
        }
        rec[m][n] = true;
        if(board[m][n] != word.charAt(start)) {
            rec[m][n] = false;
            return false;
        }
        if(board[m][n] == word.charAt(start) && start == word.length()-1) {
            return true;
        }

        if(exist(board, m-1, n, word, start+1, rec)) {
            return true;
        }
        if(exist(board, m+1, n, word, start+1, rec)) {
            return true;
        }
        if(exist(board, m, n-1, word, start+1, rec)) {
            return true;
        }
        if(exist(board, m, n+1, word, start+1, rec)) {
            return true;
        }
        rec[m][n] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length==0 || word == null || word.isEmpty()) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] rec = new boolean[m][n];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(exist(board, i, j, word, 0, rec)) {
                    return true;
                }
            }
        }
        return false;
    }

}
