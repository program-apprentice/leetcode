package com.programapprentice.app;

import com.programapprentice.util.Util;
import org.junit.Test;

import java.util.List;

/**
 * User: ruijiang
 * Date: 10/17/15
 * Time: 4:14 PM
 */
public class WordSearchII_Test {
    WordSearchII_212 obj = new WordSearchII_212();
    @Test
    public void test1() {
        String[] words = {"oath","pea","eat","rain"};
        char[][] board = {
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        };
        List<String> actual = obj.findWords(board, words);
        Util.printListString(actual);
    }

}
