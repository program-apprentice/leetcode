package com.programapprentice.app;

import java.util.PriorityQueue;

/**
 * User: program-apprentice
 * Date: 10/5/15
 * Time: 8:49 PM
 */
public class KthLargestElementInAnArray_215 {
    public void swap(int[] heap, int idx1, int idx2) {
        // cursor starts with 1.
        int tmp = heap[idx1-1];
        heap[idx1-1] = heap[idx2-1];
        heap[idx2-1] = tmp;
    }

    public void heapifyFromTop(int[] heap) {
        int index = 1;
        int value = heap[0];
        while(index <= heap.length) {
            int leftIdx = index * 2;
            int rightIdx = index * 2 + 1;
            if(heap[rightIdx-1] > heap[leftIdx-1]) {
                if(heap[index-1] > heap[leftIdx-1]) {
                    swap(heap, leftIdx, index);
                    index = leftIdx;
                } else if(heap[index-1] > heap[rightIdx-1]){
                    swap(heap, rightIdx, index);
                    index = rightIdx;
                }
            } else {
                if(heap[index-1] > heap[rightIdx-1]) {
                    swap(heap, rightIdx, index);
                    index = rightIdx;
                } else if(heap[index-1] > heap[leftIdx-1]){
                    swap(heap, leftIdx, index);
                    index = leftIdx;
                }
            }
        }
    }

    public void heapifyFromBottom(int[] heap, int heapSize) {
        int index = heapSize;
        int value = heap[heapSize-1];
        while(index != 1) { // while(index != 1)
            int parent = index / 2;
            if(heap[parent-1] > heap[index-1]) {
                swap(heap, index, parent);
                index = parent;
            } else{ // missing this section
                break;
            }
        }
    }

    public int insertHeap(int[] heap, int value, int heapSize) {
        if(heapSize == 0) {
            heap[0] = value;
            heapSize++;
            return heapSize;
        }
        if(heapSize < heap.length) {
            heap[heapSize] = value;
            heapSize++;
            heapifyFromBottom(heap, heapSize);
            return heapSize;
        }
        if(value > heap[0]) {
            heap[0] = value;
            heapifyFromTop(heap);
        }
        return heapSize;
    }

    public int findKthLargest_Failed(int[] nums, int k) {
        if(nums == null || nums.length < k) {
            return 0;
        }
        int[] heapSpace = new int[k];
        int heapSize = 0;
        for(int i = 0; i < nums.length; i++) {
            heapSize = insertHeap(heapSpace, nums[i], heapSize);
        }
        return heapSpace[0];
    }

    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length < k) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
        int i = 0;
        for(i = 0; i < k ; i++) {
            queue.add(nums[i]);
        }
        int ret;
        for(; i < nums.length; i++) {
            if(nums[i] > queue.peek()) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }
}
