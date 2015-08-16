package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/15/15
 * Time: 9:52 PM
 */
/**
 Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * */
public class ContainerWithMostWater_11 {
    // brute force
    public int maxArea_bruteforce(int[] height) {
        if(height == null || height.length <= 1) {
            return 0;
        }
        int max = 0;
        int area = 0;
        for(int i = 0; i < height.length; i++) {
            for(int j = i; j < height.length; j++) {
                area = Math.min(height[i], height[j]) * (j - i);
                max = max > area ? max : area;
            }
        }
        return max;
    }

    public int maxArea(int[] height) {
        if(height == null || height.length <= 1) {
            return 0;
        }
        int max = 0;
        int area = 0;
        int low = 0;
        int high = height.length - 1;
        while(low < high) {
            area = Math.min(height[low], height[high]) * (high - low);
            max = max > area ? max : area;
            if(height[low] > height[high]) {
                high--;
            } else {
                low++;
            }
        }
        return max;
    }

}
