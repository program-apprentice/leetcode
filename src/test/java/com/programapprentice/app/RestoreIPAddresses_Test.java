package com.programapprentice.app;

import com.programapprentice.util.Util;
import org.junit.Test;

import java.util.List;

/**
 * User: program-apprentice
 * Date: 9/6/15
 * Time: 11:05 PM
 */
public class RestoreIPAddresses_Test {
    RestoreIPAddresses_93 obj = new RestoreIPAddresses_93();

    @Test
    public void test1() {
        String s = "25525511135";
        List<String> output = obj.restoreIpAddresses(s);
        Util.printListString(output);
    }

    @Test
    public void test2() {
        String s = "010010";
        List<String> output = obj.restoreIpAddresses(s);
        Util.printListString(output);
    }

}
