package Leetcode.DP;

import java.util.*;
//https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/?envType=daily-question&envId=2024-12-28
// https://www.youtube.com/watch?v=aGmHF7Rs0R8
public class _689_max_sum_of_3_non_overlapping_subarrays {
    public static void main(String[] args) {
        int [] arr = {1,2,1,2,6,7,5,1};
        int k = 2;
        System.out.println(Arrays.toString(maxSumOfThreeSubarrays(arr, k)));
    }

    // TC : O(n)
    // SC : O(n * 4)
    static int [][] dp = new int[20001][4];
    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        // storing the subarray for each index, index i store the sum of k size subarray starting from index i
        List<Integer> prefix = new ArrayList<>();
        int i = 0;
        int j = 0;
        int windowSum = 0;
        while(j < n){ // O(N)
            windowSum += nums[j];
            if(j-i+1 == k){
                prefix.add(windowSum);
                windowSum -= nums[i];
                i++;
            }
            j++;
        }

        for(int [] a : dp) Arrays.fill(a, -1);

        List<Integer> ans = new ArrayList<>();
        solve(prefix, k, 0, 3, ans);
        int [] res = new int[3];
        System.out.println(ans);
        for(int l = 0; l < 3; l++) res[l] = ans.get(l);
        return res;
    }
    // O(n) but why ?
    // because the solve function will run for n times in the worst case, because of the if else, either it will move by ind + k or ind + 1, so n time in the worst case
    // and the helper function will run n * 3 times in at max
    // but the dp table for helper function will already be filled before any other solve call, so next time for any number of calls helper will give the answer in O(1) time
    static void solve(List<Integer> prefix , int k, int ind, int count, List<Integer> ans){
        if(count == 0) return;
        if(ind >= prefix.size()) return;

        // finding which gives the max sum, starting the subarray from this index of not starting the subarray from the index
        int take = prefix.get(ind) + helper(prefix, k, ind + k, count - 1);
        int not = helper(prefix, k, ind + 1, count);

        // if starting the subarray gives the max value then add the index to the ans and solve for next index = ind + k, it should be non overlapping so next index will be at ind + k
        if(take >= not){
            ans.add(ind);
            solve(prefix, k, ind + k, count - 1, ans);
        }
        else solve(prefix, k, ind + 1, count, ans);
    }

    // O(n * 3)
    public static int helper(List<Integer> prefix , int k, int ind, int count){
        if(count == 0) return 0;
        if(ind >= prefix.size()) return Integer.MIN_VALUE;

        if(dp[ind][count] != -1) return dp[ind][count];
        // finds the sum from the current index, we return the max sum between take and not take
        int take = prefix.get(ind) + helper(prefix, k, ind + k, count - 1);
        int not = helper(prefix, k, ind + 1, count);
        return dp[ind][count] = Math.max(take, not);
    }
}
