package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/14/15
 * Time: 11:01 PM
 * Finished Time: 11:12 PM
 */
// https://leetcode.com/problems/rectangle-area/
public class RectangleArea_223 {
    public int findCommonRage(int low1, int high1, int low2, int high2) {
        if(low2 >= high1 || high2 <= low1) {
            return 0;
        }
        int low = 0;
        int high = 0;
        low = Math.max(low1, low2);
        high = Math.min(high1, high2);
        return high - low;
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int cHeight = findCommonRage(B, D, F, H); // find common height y
        int cWidth = findCommonRage(A, C, E, G); // find common width x
        int commonArea =  cHeight * cWidth;
        int rect1 = (D - B) * (C - A);
        int rect2 = (H - F) * (G - E);
        return rect1 + rect2 - commonArea;
    }
}
