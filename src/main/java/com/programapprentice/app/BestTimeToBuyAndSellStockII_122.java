package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 9/9/15
 * Time: 5:46 PM
 */
public class BestTimeToBuyAndSellStockII_122 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) { // if(prices == null || prices.length == 1) {
            return 0;
        }
        int max = 0;
        int pre = prices[0];
        int cur = 0;
        for(int i = 1; i < prices.length; i++) {
            cur = prices[i];
            if(cur > pre) {
                max += cur - pre;
            }
            pre = cur;
        }
        return max;
    }
}
