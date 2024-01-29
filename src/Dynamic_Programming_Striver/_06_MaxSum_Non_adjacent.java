package Dynamic_Programming_Striver;

import java.util.Arrays;
//https://leetcode.com/problems/house-robber/description/
public class _06_MaxSum_Non_adjacent {
    public int rob(int[] nums) {
        int [] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums.length - 1, nums, dp);
    }
    int helper(int index, int[] arr, int [] dp){
        // if index is 0 that means we have not taken index 1 so we have to add arr[index] in the answer
        if(index == 0) return arr[0];
        if(index == -1) return 0;

        if(dp[index] != -1) return dp[index];

        // this pick and not pick is the subsequence pattern we learned in recursion
        // do all stuffs on index , either we take the index and take the element behind two index
        int pick = arr[index]+helper(index-2, arr, dp);
        // or we leave/ no pick current index and take its previous index
        int notPick = 0 + helper(index-1, arr, dp);

        return dp[index]=Math.max(pick, notPick);
    }
    // bottom up tabulation approach
    public static int maxSum(int index, int [] arr, int [] dp){
        dp[0]= arr[0];
        int neg = 0; // we can't store negative index in array so declaring a variable for that

        for (int i = 1; i < arr.length; i++) {
            int pick = arr[i];
            if(i > 1) pick += dp[i - 2]; // if i is 1 or less then the value of dp[i - 2] will be 0 , so no need to add that in the answer
            int notPick = dp[0] + dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[arr.length - 1];
    }

}
