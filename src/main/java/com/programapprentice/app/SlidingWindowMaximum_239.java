package com.programapprentice.app;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * User: program-apprentice
 * Date: 10/12/15
 * Time: 10:42 PM
 */
public class SlidingWindowMaximum_239 {

    public int[] maxSlidingWindowTooSlow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length < k) {
            return null;
        }
        PriorityQueue<Integer> queue= new PriorityQueue<Integer>(k);
        int[] output = new int[nums.length-k+1];
        int i = 0;
        for(i = 0; i < k; i++) {
            queue.offer(nums[0]);
        }
        int index = 0;
        for(i=k; i< nums.length; i++) {
            output[index] = queue.peek();
            queue.remove(i-k);
            queue.add(nums[k]);
            index++;
        }
        return output;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1 || k == 0) {
            return nums;
        }
        if(nums == null || nums.length == 0 || nums.length < k) {
            return null;
        }

        LinkedList<Integer> list = new LinkedList<Integer>();

        int[] record = new int[nums.length-k+1];
        int recordIdx = 0;
        list.add(0);
        int cur = 0;
        for(int i = 1; i < nums.length; i++) {
            cur = nums[i];
            if(i - list.get(0) >= k) {
                list.removeFirst();
            }
            // delete backward, delete all index which has number less than cur
            while(!list.isEmpty()) {
                if(nums[list.getLast()] <= cur) { // wrong: if(list.peek() <= cur) {
                    list.removeLast();
                } else {
                    break;
                }
            }
            list.add(i); // wrong: list.add(cur);

            if(i >= k-1) {
                record[recordIdx] = nums[list.get(0)];
                recordIdx++;
            }
        }
        return record;
    }
}
