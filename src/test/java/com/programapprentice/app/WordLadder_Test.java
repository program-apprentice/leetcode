package com.programapprentice.app;


import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class WordLadder_Test {
    WordLadder_127 obj = new WordLadder_127();
    @Test
    public void test1() {
        String start = "hot";
        String end = "dog";
        String[] wordList = {"hot","dog","dot"};
        Set<String> dict = new HashSet<String>();
        for(String s : wordList) {
            dict.add(s);
        }
        int actual = obj.ladderLength(start, end, dict);
        int expected = 3;
        assertEquals(actual, expected);
    }

}
