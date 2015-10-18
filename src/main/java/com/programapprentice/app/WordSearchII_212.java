package com.programapprentice.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: ruijiang
 * Date: 10/17/15
 * Time: 3:36 PM
 */
public class WordSearchII_212 {
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

    public List<String> findWordsTooSlow(char[][] board, String[] words) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return new ArrayList<String>();
        }

        List<String> output = new ArrayList<String>();
        for(String word : words) {
            if(exist(board, word)) {
                output.add(word);
            }
        }
        return output;
    }


    /******************** Optimized Solution *******************************/
    private static final int R = 26;
    class TrieNode {
        boolean isEndOfWord;
        Character c;
        TrieNode[] children;
        String value;
        public TrieNode(Boolean isEndOfWord, Character c, String value) {
            this.isEndOfWord = isEndOfWord;
            this.c = c;
            this.value = value;
            this.children = new TrieNode[R];
        }
    }

    private TrieNode root = new TrieNode(false, null, null);

    private void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode child = node.children[c - 'a'];
            if(child == null) {
                child = new TrieNode(false, c, null);
            }
            node.children[c - 'a'] = child;
            if(i == word.length()-1) {
                child.isEndOfWord = true;
                child.value = word;
            }
            node = child;
        }
    }

    private void buildTrie(String[] words) {
        for(String word : words) {
            addWord(word);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> output = new ArrayList<String>();
        if(board == null || board.length == 0 || board[0].length == 0) {
            return output;
        }
        int h = board.length;
        int w = board[0].length;
        buildTrie(words);
        boolean[][] visited = new boolean[h][w];
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                dfs(board, visited, output, root, i, j);
            }
        }
        Collections.sort(output);
        return output;
    }

    // up down left right
    public void dfs(char[][] board, boolean[][] visited, List<String> foundWords, TrieNode node, int row, int col ) {
        char cur = board[row][col];
        TrieNode child = node.children[cur - 'a'];
        if(child == null) {
            return;
        }
        if(child.isEndOfWord) {
            if(!foundWords.contains(child.value)) {
                foundWords.add(child.value);
            }
        }
        visited[row][col] = true;
        if(row > 0 && !visited[row-1][col]) {
            dfs(board, visited, foundWords, child, row-1, col);
        }
        if(row < board.length-1 && !visited[row+1][col]) {
            dfs(board, visited, foundWords, child, row+1, col);
        }
        if(col > 0 && !visited[row][col-1]) {
            dfs(board, visited, foundWords, child, row, col-1);
        }
        if(col < board[0].length-1 && !visited[row][col+1]) {
            dfs(board, visited, foundWords, child, row, col+1);
        }
        visited[row][col] = false;
    }
}
