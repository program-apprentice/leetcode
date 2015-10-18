package com.programapprentice.app;

/**
 * User: ruijiang
 * Date: 10/17/15
 * Time: 4:48 PM
 */
public class BestTimeToBuyAndSellStockIII_123 {
    /**
     * 1. find max profit left to i
     * 2. find max profit right to i
     * 3. find total max profit
     * */
    public int[] calLeft(int[] prices) {
        // buy before i, and sell at i;
        int[] leftMax = new int[prices.length];
        int max = 0;
        int min = prices[0];
        int pre = prices[0];
        int cur = 0;
        for(int i = 1; i < prices.length; i++) {
            cur = prices[i];
            if(cur > pre) {
                leftMax[i] = Math.max(cur - min, max);
                max = Math.max(max, leftMax[i]);
            } else if (cur < pre) {
                min = Math.min(cur, min);
                leftMax[i] = leftMax[i-1];
            } else { // cur == pre
                leftMax[i] = leftMax[i-1];
            }
            pre = cur;
        }
        return leftMax;
    }

    // buy at i+1
    public int[] calRight(int[] prices) {
        int[] right = new int[prices.length];
        int afterCur = prices[prices.length-1];
        int cur = prices[prices.length-2];
        int maxProfit = 0;
        int maxRecord = Math.max(afterCur, cur);
        for(int i = prices.length-2; i >= 0; i--) {
            if(cur < afterCur) {
                right[i] = Math.max(maxRecord - cur, maxProfit);
                maxProfit = Math.max(maxProfit, right[i]);
            } else if (cur > afterCur) {
                maxRecord = Math.max(cur, maxRecord);
                right[i] = right[i+1];
            } else { // cur == afterCur
                right[i] = right[i+1];
            }
            afterCur = cur;
            cur = prices[i];
        }
        return right;
    }

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }
        int[] leftMax = calLeft(prices);
        int[] rightMax = calRight(prices);
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            int cur = leftMax[i] + rightMax[i];
            maxProfit = Math.max(maxProfit, cur);
        }
        return maxProfit;
    }
}
