package Leetcode.Array;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/?envType=daily-question&envId=2024-10-30

// This problem is hard marked on leetcode because of the thought process it needs to solve, otherwise the problem is medium, we have to remove min number of element from the nums array to make the nums array a mountain array
// and to do so, we have to find the LIS and LDS for each index, then we can found the length of the mountain. now we can subtract its length from the total length of the array to get our answer

// in recursion we can't store LIS for every index and we need that for that question, we can't work with taking the LIS for the entire array in this question, so recursion won't help here
public class _1671_min_removals_to_make_mountain_array {
    public static void main(String[] args) {
        int [] nums = {2,1,1,5,6,2,3,1};
        System.out.println(Arrays.toString(nums));
//        System.out.println(minimumMountainRemovals(nums));
    }

    // TC : O(n ^ 2)
    // SC : O(n)
    public static int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int ans = n;
        int [] LIS = new int[n];
        Arrays.fill(LIS, 1);
        int [] LDS = new int[n];
        Arrays.fill(LDS, 1);

        // Longest increasing subsequences
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]) LIS[i] = Math.max(LIS[i], LIS[j] + 1);
            }
        }

        // Longest decreasing subsequences
        for(int i = n-1; i >= 0; i--){
            for(int j = n - 1; j > i; j--){
                if(nums[i] > nums[j]) LDS[i] = Math.max(LDS[i], LDS[j] + 1);
            }
        }

        for(int i = 0; i < n; i++){
            if(LIS[i] > 1 && LDS[i] > 1) // if left and right are not greater than 1, then the length would not be greater than 3, and the question says that mountain array needs to have at least length >= 3
                // this is derived from
                // LIS[i] + LDS[i] - 1 == total length of mountain, doing -1 because the current index is inclusive in both the cases
                // and removal = n - (LIS[i] + LDS[i] - 1)
                // taking min because ans is no of removal
                ans = Math.min(ans, n + 1 - LIS[i] - LDS[i]);
        }
        return ans;
    }
}
