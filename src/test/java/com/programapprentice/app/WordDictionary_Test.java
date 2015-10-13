package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 10/12/15
 * Time: 9:46 PM
 */
public class WordDictionary_Test {
    WordDictionary obj = new WordDictionary();
    @Test
    public void test1() {
        obj.addWord("a");
        assertEquals(true, obj.search("a"));
//        assertEquals(false, obj.search("b"));
        assertEquals(true, obj.search("."));
    }

    @Test
    public void test2() {
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
//        assertEquals(false, obj.search("pad"));
//        assertEquals(true, obj.search("bad"));
//        assertEquals(true, obj.search(".ad"));
//        assertEquals(true, obj.search("b.."));
        assertEquals(true, obj.search("..."));
        assertEquals(true, obj.search(".a."));
        assertEquals(true, obj.search("..d"));
    }

    @Test
    public void test3() {
        obj.addWord("ran");
        obj.addWord("rune");
        obj.addWord("runner");
        obj.addWord("runs");
        obj.addWord("add");
        obj.addWord("adds");
        obj.addWord("adder");
        obj.addWord("addee");
//        assertEquals(true, obj.search("r.n"));
//        assertEquals(false, obj.search("ru.n.e"));
//        assertEquals(true, obj.search("add"));
//        assertEquals(true, obj.search("add."));
//        assertEquals(true, obj.search("adde."));
//        assertEquals(false, obj.search(".an."));
//        assertEquals(true, obj.search("...s"));
        assertEquals(true, obj.search("....e."));
//        assertEquals(false, obj.search("......."));
//        assertEquals(false, obj.search("..n.r"));
    }
}
