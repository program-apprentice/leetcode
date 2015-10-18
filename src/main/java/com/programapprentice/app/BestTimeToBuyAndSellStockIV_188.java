package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 10/17/15
 * Time: 9:27 PM
 */
public class BestTimeToBuyAndSellStockIV_188 {
    // http://wlcoding.blogspot.com/2015/03/best-time-to-buy-and-sell-stock.html?view=sidebar
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int profit = 0;

        if(k > n/2) { // equals to as many transactions as possible
            for(int i = 1; i < n; i++) {
                int diff = prices[i] - prices[i-1];
                if(diff > 0) {
                    profit += diff;
                }
            }
            return profit;
        }
        int[][] record = new int[k+1][n];
        for(int i = 1; i <= k; i++) {
            int tmpMax = record[i-1][0] - prices[0];
            for(int j = 1; j < n; j++) {
                tmpMax = Math.max(tmpMax, record[i-1][j-1] - prices[j]);
                record[i][j] = Math.max(record[i][j-1], tmpMax + prices[j]);
            }
        }
        return record[k][n-1];
    }
}
