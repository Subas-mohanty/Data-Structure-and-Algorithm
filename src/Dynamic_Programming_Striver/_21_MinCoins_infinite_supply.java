package Dynamic_Programming_Striver;

import java.util.Arrays;
//https://bit.ly/3HJTeIl

public class _21_MinCoins_infinite_supply {
    public static void main(String[] args) {
        int [] coins = {1,2,5};
        int n = coins.length;
        int target = 11;
        System.out.println(minCoin(coins, n-1, target));

//        when no answer found return -1 , stated in the question
//        int ans = minCoin(coins, n-1, target);
//        if(ans >= (int)1e9) System.out.println(-1);
//        System.out.println(ans);

        int [][] dp = new int[n][target+1];
        for(int [] a: dp) Arrays.fill(a, -1);
        System.out.println(minCoin2(coins, n-1, target, dp));

        int [][] Dp = new int[n][target+1];
        System.out.println(minCoin3(coins, target, dp));
    }
    // TC : exponential , >>> 2^n , because here we have more than 2 options for an element so theoretically it's very difficult to say the exact time complexity
    // SC : O(target) , not O(n) because the if everytime we pick 1 then the stack will have target number of elements at a time
    public static int minCoin(int [] coins, int ind, int target){
        if(ind == 0 ){
            // when we are at the 0th index we have two options either we can form the target of not so, if we can't form we will not return 0 instead a bigger value(not int_max, because we are adding something in the previous function call with it so it may get overflowed) which means we can't form target using this value, if we return 0 that means we can form the target without taking the element(0 times)

            // [4] , target = 12 , so we have to pick 4, 3 times that's why doing modulo and all these
            if(target % coins[0] == 0) return target/coins[0];
            else return (int) 1e9; // 1e9 means 10^9
        }
        int notPick = minCoin(coins, ind - 1, target);
        int pick = Integer.MAX_VALUE;
        // notice in the take function call we are passing the same ind, because we want to take the same element multiple time if possible
        if(target >= coins[ind]) pick = 1 + minCoin(coins, ind, target - coins[ind]);
        return Math.min(pick, notPick);
    }
    // TC : O(ind*target)
    // SC : still O(target) + O(ind*target) --> for the dp array
    public static int minCoin2(int [] coins, int ind, int target, int [][] dp){
        if(ind == 0 ){
            if(target % coins[0] == 0) return target/coins[0];
            else return (int) 1e9; // 1e9 means 10^9
        }

        if(dp[ind][target] != -1) return dp[ind][target];

        int notPick = minCoin2(coins, ind - 1, target, dp);
        int pick = Integer.MAX_VALUE;
        // notice in the take function call we are passing the same ind, because we want to take the same element multiple time if possible
        if(target >= coins[ind]) pick = 1 + minCoin2(coins, ind, target - coins[ind], dp);
        return dp[ind][target] = Math.min(pick, notPick);
    }
    public static int minCoin3(int [] coins, int target, int [][] dp){
        int n = coins.length;
        for (int i = 0; i <= target; i++) {
            if(i % coins[0] == 0) dp[0][i] = i/coins[0];
            else dp[0][i] = (int) 1e9;
        }
        for (int ind = 1; ind < n; ind++) {
            for (int j = 0; j <= target; j++) {
                int notPick = dp[ind - 1][j];
                int pick = Integer.MAX_VALUE;
                // notice in the take function call we are passing the same ind, because we want to take the same element multiple time if possible
                if(j >= coins[ind]) pick = 1 + dp[ind][j - coins[ind]];
                dp[ind][j] = Math.min(pick, notPick);
            }
        }
        return dp[n-1][target];
    }
}
