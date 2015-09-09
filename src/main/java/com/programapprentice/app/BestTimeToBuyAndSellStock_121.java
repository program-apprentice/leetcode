package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 9/8/15
 * Time: 10:30 PM
 */
public class BestTimeToBuyAndSellStock_121 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        int[] minRec = new int[prices.length];
        minRec[0] = prices[0];
        for(int i = 1; i < prices.length; i++) {
            minRec[i] = prices[i] < minRec[i-1] ? prices[i] : minRec[i-1];
        }
        for(int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - minRec[i-1];
            max = max > tmp ? max : tmp;
        }
        return max;
    }

    public int maxProfit_v2(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }

        int max = 0;
        int min = prices[0];

        for(int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - min;
            max = max > tmp ? max : tmp;
            min = min < prices[i] ? min : prices[i];
        }

        return max;
    }
}
