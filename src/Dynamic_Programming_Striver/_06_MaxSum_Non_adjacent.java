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

        // do all stuffs on index , either we take the index and take the element behind two index
        int pick = arr[index]+helper(index-2, arr, dp);
        // or we leave/ no pick current index and take its previous index
        int notPick = 0 + helper(index-1, arr, dp);

        return dp[index]=Math.max(pick, notPick);
    }
}
