package Leetcode.Heap;

import Leetcode.Pair;
import java.util.PriorityQueue;
//https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/editorial/?envType=daily-question&envId=2024-11-17

class _862_shortest_subarray_with_sum_k {

    // Why we are doing what we are doing ?
    // The brute force approach would be to loop over all subarrays in nums and check if their sums exceed k. The smallest one among them is our answer. However, this approach is too slow for our constraints.

    //Let's identify the redundancies in the above approach. One major issue is that we keep recalculating the same subarray sums multiple times. We can solve this by creating a prefix sum array, which lets us quickly find the sum of any subarray. Using this array, we can look at each element and find an earlier prefix sum that, when subtracted from our current sum, gives us a value of at least k.

    // However, searching for the best prefix sum for each index is still too slow. What we really need is a way to quickly find the "best" prefix sum – one with the lowest value that's also closest to our current position.

    // TC : O(n * log n)
    // SC : O(n)
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;

        // sorting the heap based on the cumulative sum, we didn't use an array to store because to find the min value in array will take O(n) time
        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        long sum = 0;
        int ans = (int)1e9;
        // going to each index and finding the cumulative sum,
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            // this case is for, if our answer is = len of array and, it takes all the elements to make the sum
            if(sum >= k){
                ans = Math.min(ans, i + 1);
            }

            // getting the smallest value which subtracted from the sum give res >= k, and we keep doing it to find the shortest length of the sub-array
            while(!pq.isEmpty() && sum - pq.peek().getKey() >= k){
                ans = Math.min(ans, i - pq.peek().getValue());
                pq.poll();
            }

            // add the current sum with its index into the heap
            pq.offer(new Pair<>(sum , i));
        }
        return ans;
    }

}