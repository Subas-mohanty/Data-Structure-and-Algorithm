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
        return left;
    }
    public boolean checkPair(int mid, int [] nums, int k){
        int n = nums.length;
        int j = 1;
        int total = 0;
        for(int i = 0; i < n; i++){
            while(j < n && nums[j] - nums[i] <= mid) j++;
            j--;
            int diff = j - i;
            total += diff;
        }
        return total >= k;
    }
}
