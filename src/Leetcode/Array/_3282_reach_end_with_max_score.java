package Leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/reach-end-of-array-with-max-score/

public class _3282_reach_end_with_max_score {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(4,3,1,3,2));
        System.out.println(findMaximumScore(list));
        System.out.println(findMaximumScore2(list));
    }

    // gives TLE
    // TC : O(n*n) --> look at the recursive call inside the for loop which is causing an extra n
    public static long findMaximumScore(List<Integer> nums) {
        int n = nums.size();
        long [] dp = new long[n];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);
    }
    static long helper(List<Integer> list, int ind, long [] dp){
        int n = list.size();
        if(ind == n) return 0;

        long max = 0;
        if(dp[ind] != -1) return dp[ind];
        for(int i = ind + 1; i < n; i++){
            long take = (long) (i - ind) * list.get(ind) + helper(list, i, dp);
            max = Math.max(take, max);
        }
        return dp[ind] = max;
    }


    // this is also giving TLE, there is a optimal approach, I will learn it later
    public static long findMaximumScore2(List<Integer> list) {
        int n = list.size();
        long [] dp = new long[n+1];
        dp[n] = 0;
        for(int i = n-1; i >= 0; i--){
            long max = 0;
            for (int j = i+1; j < n; j++) {
                long take = (long)(j-i) * list.get(i) + dp[j];
                max = Math.max(max, take);
            }
            dp[i] = max;
        }
        return dp[0];
    }
}
