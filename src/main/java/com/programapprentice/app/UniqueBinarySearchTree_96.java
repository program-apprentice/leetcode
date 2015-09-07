package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 9/6/15
 * Time: 11:42 PM
 */
public class UniqueBinarySearchTree_96 {
    public int numTrees(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        int[] rec = new int[n+1];
        rec[0] = 1;
        rec[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int k = 0; k < i; k++) { // wrong:for(int k = 0; k < i; i++) {
                rec[i] += rec[k] * rec[i-k-1];
            }
        }
        return rec[n];
    }
}
