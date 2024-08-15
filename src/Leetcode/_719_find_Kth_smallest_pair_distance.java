package Leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/?envType=daily-question&envId=2024-08-14

public class _719_find_Kth_smallest_pair_distance {

    // TC : O(n log n)
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int diff = nums[n-1] - nums[0];
        int left = 0;
        int right = diff;

        // binary search
        while(left < right){
            int mid = (left+right)/2;
            if(checkPair(mid, nums, k)){
                right = mid;
            }
            else left = mid+1;
        }
        // return right // we can return right also , because the loop ends when left == right so we can return any of them
        return left;
    }
    public boolean checkPair(int mid, int [] nums, int k){
        int n = nums.length;
        int j = 1;
        int total = 0;
        for(int i = 0; i < n; i++){

            // sliding window, starting j from 1 and checking how many pairs are present where the difference between them is <= mid

            // total gives us the total numbers of pairs where the diff is <= mid, or the number of smallest element present where the difference is mid

            // if the number of smallest element is >= k, we need to reduce the value so we are returning true and moving right to mid in the binary search to find the ans in the left
            while(j < n && nums[j] - nums[i] <= mid) j++;
            j--;
            int noOfPairs = j - i;
            total += noOfPairs;
        }
        return total >= k;
    }
}
