package Leetcode;

import java.util.Arrays;

public class _70_canJump {
    public static void main(String[] args) {
       int [] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
        System.out.println(helper(nums));
    }
    public static boolean canJump(int[] nums) {
        int [] dp = new int[nums.length];
        Arrays.fill(dp, -1);

         return f(nums, 0, nums.length, dp);

    }
    public static boolean helper(int [] arr){

        // if the array doesn't contain 0 we can always reach the last index
        // but here we are checking from the second last index, if we can reach the last index from that index we can update our goal to that index and check for prev indices
        int n = arr.length;
        int goal = n-1;
        for(int i = n-2; i>=0; i--){
            if(i + arr[i] >= goal) goal = i;
        }
        return goal == 0;
    }
    // TC : O(n*n)
    // SC : O(n*n)
    public static boolean f(int [] arr, int ind, int n, int[] dp){
        if(ind == n-1) return true;
        if(ind >=n ) return false;

        if(dp[ind] != -1) return dp[ind] == 1;
        boolean ans = false;
        for(int i = 1 ; i<= arr[ind]; i++){
            boolean jump = f(arr, ind+i, n, dp);
            ans = ans || jump;
        }
        // ans ? dp[ind] = 1 : dp[ind] = 0; // not working , don't know why
        if(ans) dp[ind] = 1;
        else dp[ind] = 0;
        return ans;
    }
}
