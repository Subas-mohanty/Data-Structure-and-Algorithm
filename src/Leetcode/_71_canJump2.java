package Leetcode;

import java.util.Arrays;

public class _71_canJump2 {
    public static void main(String[] args) {
        int [] arr = {2,3,0,1,4};
        System.out.println(canJump(arr));
    }


    // TC : O(n)
    // SC : O(1)
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        // if first element is greater than the length of the array then in one jump we can reach at the end of the array
        if(nums[0] >= nums.length) return 1;
        int end = nums[0];
        int jump = 0; // no of jumps
        int maxJump = 0; // at each index , by taking the maximum jump where we reach
        // 2 3 0 1 4
        //     e
        // maxJump = 2
        
        for(int i = 0; i< nums.length; i++){
            maxJump = Math.max(i + nums[i], maxJump);
            if(end == i){
                jump++;
                end = Math.min(maxJump, nums.length - 1);
            }
        }

        return jump;
    }


    // TC : O(n^2) , dp array and the for loop inside it
    // SC : O(n)
    public static int canJump(int[] nums) {
        int [] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        int ans = f(nums, 0, nums.length, dp);
        return ans == (int) 1e9 ? -1 : ans;
    }
    public static int f(int [] arr, int ind, int n, int[] dp){
        if(ind == n-1) return 0;
        if(ind >=n ) return (int)1e9;
        if(arr[ind] == 0) return (int)1e9;

        // 2 3 0 1 4
        if(dp[ind] != -1) return dp[ind];
        int ans = Integer.MAX_VALUE;
        for(int i = 1 ; i<= arr[ind]; i++){
            int jump =1+ f(arr, ind+i, n, dp);
            ans = Math.min(ans, jump);
        }
        return dp[ind] = ans;
    }
}
