package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 10/4/15
 * Time: 12:35 PM
 */
public class MinimumSizeSubarraySum_209 {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] lengthRec = new int[n];
        lengthRec[0] = nums[0] >= s ? 1 : 0;
        int startIdx = -1;
        if(lengthRec[0] == 1) {
            return 1;
        }
        int[] sumRec = new int[n];

        sumRec[0] = nums[0];
        int counter = 0;
        for(int i = 1; i < n; i++) {
            if(sumRec[i-1] < s) {
                sumRec[i] = sumRec[i-1] + nums[i];
                if(sumRec[i] >= s) {
                    if(startIdx == -1) {
                        startIdx = i;
                    }
                    lengthRec[i] = i+1;
                    int tmpSum = sumRec[i];
                    for(int j = 0; j <= i; j++) {
                        if(tmpSum - nums[j] >= s) {
                            tmpSum -= nums[j];
                            counter++;
                        } else {
                            lengthRec[i] -= counter;
                            sumRec[i] = tmpSum;
                            break;
                        }
                    }
                }
            } else {
                int tmpSum = sumRec[i-1] + nums[i];
                lengthRec[i] = lengthRec[i-1] + 1;
                counter = 0;
                for(int j = i - lengthRec[i-1]; j <= i; j++) {
                    if(tmpSum - nums[j] >= s) {
                        tmpSum -= nums[j];
                        counter++;
                    } else {
                        lengthRec[i] -= counter;
                        sumRec[i] = tmpSum;
                        break;
                    }
                }
            }
        }
        if(startIdx == -1) { // missing this section
            return 0;
        }

        int min = nums.length;
        for(int i = startIdx; i < n; i++) {
            min = lengthRec[i] > min ? min : lengthRec[i];
        }
        return min;
    }
}
