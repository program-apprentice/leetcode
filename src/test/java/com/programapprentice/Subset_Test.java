package com.programapprentice;

import com.programapprentice.app.Subset_78;
import com.programapprentice.util.Util;
import org.junit.Test;

import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/21/15
 * Time: 6:35 PM
 */
public class Subset_Test {
    Subset_78 obj = new Subset_78();

    @Test
    public void test1() {
        int[] nums = {0};
        List<List<Integer>> actual =  obj.subsets(nums);
        Util.printListOfListNumbers(actual);
    }
}
