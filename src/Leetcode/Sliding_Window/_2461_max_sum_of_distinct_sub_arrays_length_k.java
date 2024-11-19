package Leetcode.Sliding_Window;

import java.util.*;

//https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/?envType=daily-question&envId=2024-11-19

public class _2461_max_sum_of_distinct_sub_arrays_length_k {

    // TC : O(n)
    // SC : O(1)
    public long maximumSubarraySum(int[] nums, int k) {
        long answer = 0;
        long sum = 0;
        int s = 0, e = 0;
        // store num and their last seen index
        Map<Integer, Integer> map = new HashMap<>();

        while (e < nums.length) {
            int num = nums[e];
            int lastSeen = map.getOrDefault(num, -1);

            // if window size is > k, then move the start pointer forward or if the last occurences of the current element is == s or < s, this is to make sure the window don't have any duplicate value
            while (s <= lastSeen || e - s + 1 > k) {
                sum -= nums[s];
                s++;
            }

            map.put(num, e);
            sum += num;

            // our window is valid, size = k and element are distinct
            if (e - s + 1 == k) {
                answer = Math.max(answer, sum);
            }

            e++;
        }

        return answer;
    }
}
