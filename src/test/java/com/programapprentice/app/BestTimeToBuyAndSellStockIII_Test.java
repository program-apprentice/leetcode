package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 10/17/15
 * Time: 9:20 PM
 */
public class BestTimeToBuyAndSellStockIII_Test {
    BestTimeToBuyAndSellStockIII_123 obj = new BestTimeToBuyAndSellStockIII_123();
    @Test
    public void test1() {
        int[] prices = {1, 2};
        int actual = obj.maxProfit(prices);
        int expected = 1;
        assertEquals(expected, actual);
    }
}
