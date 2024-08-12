package Leetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-a-stream/?envType=daily-question&envId=2024-08-12

// what we are doing is, we created a heap, where we are storing only k elements, when we add a value into it, we are checking if the value is smaller than the top of the heap, then the Kth largest element will be at the top of the heap, if the value is greater, then we add it in the heap, and after adding we check if the size of the heap is greater than K, we need to remove the top element to maintain the heap size equal to K
public class _703_KthLargest_element_in_stream {
  PriorityQueue<Integer> minHeap;
    int k;
    public _703_KthLargest_element_in_stream(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.k = k;
        for(int num : nums) add(num);
    }
   
    public int add(int val) {
        if(minHeap.size() < k || val > minHeap.peek()){
            minHeap.offer(val);
            if(minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }
}
