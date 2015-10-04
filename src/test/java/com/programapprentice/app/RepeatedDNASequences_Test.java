package com.programapprentice.app;

import com.programapprentice.util.Util;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 10/3/15
 * Time: 11:32 PM
 */
public class RepeatedDNASequences_Test {
    RepeatedDNASequences_187 obj = new RepeatedDNASequences_187();

    @Test
    public void test1() {
        String input = "AAAAAAAAAA";
        List<String> actual = obj.findRepeatedDnaSequences(input);
    }

    @Test
    public void test2() {
        String input = "AAAAAAAAAAA";
        List<String> actual = obj.findRepeatedDnaSequences(input);
        Util.printListString(actual);
    }

    @Test
    public void test3() {
        String input = "GAGAGAGAGAGA";
        List<String> actual = obj.findRepeatedDnaSequences(input);
        Util.printListString(actual);
    }
}
