package com.programapprentice.app;

import org.junit.Test;

import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/15/15
 * Time: 12:38 PM
 */
public class SummaryRanges_Test {
    SummaryRanges_228 obj = new SummaryRanges_228();
    @Test
    public void test1() {
        int[] nums = {0, 1, 2};
        String[] expected = {"1->2"};
        List<String> actual = obj.summaryRanges(nums);

    }
}
