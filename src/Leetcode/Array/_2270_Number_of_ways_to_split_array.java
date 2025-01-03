package Leetcode.Array;

// https://leetcode.com/problems/number-of-ways-to-split-array/?envType=daily-question&envId=2025-01-03

public class _2270_Number_of_ways_to_split_array {
    // TC : O(n + n)
    // SC : O(1)
    public int waysToSplitArray(int[] nums) {
        int count = 0;
        
        long sum = 0;
        for(int a : nums) sum += a;

        // count left sum 
        long left = 0;
        for(int i = 0; i < nums.length -1; i++){
            left += nums[i];
            // find right sum by subtracting left sum from the total sum
            long right = sum - left;
            if(left >= right) count++;
        }
        return count;
    }
}
