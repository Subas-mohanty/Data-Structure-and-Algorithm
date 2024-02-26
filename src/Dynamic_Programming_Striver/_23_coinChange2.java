package Dynamic_Programming_Striver;

import java.util.Arrays;

public class _23_coinChange2 {
    public static void main(String[] args) {
        int [] coins = {1,2,3};
        int n = coins.length;
        int value = 4;
        System.out.println(minCoins(coins, n-1, value));

        long [][] dp = new long[n][value+1];
        for(long [] a : dp) Arrays.fill(a, -1);
        System.out.println(minCoins2(coins, n-1, value, dp));

        long [][] Dp = new long[n][value+1];
        System.out.println(minCoins3(coins, value, Dp));
    }
    public static long minCoins(int[] coins, int ind, int value){
        if(value == 0 ) return 1;
        if(ind == 0){
            if(value % coins[0] == 0) return 1;
            return 0;
        }
        long notPick = minCoins(coins, ind-1, value);
        long pick = 0;
        if(coins[ind] <= value) pick = minCoins(coins, ind, value - coins[ind]);

        return notPick + pick;
    }
    public static long minCoins2(int[] coins, int ind, int value, long [][] dp){
        if(value == 0 ) return 1;
        if(ind == 0){
            if(value % coins[0] == 0) return 1;
            return 0;
        }
        if(dp[ind][value] != -1) return dp[ind][value];
        long notPick = minCoins2(coins, ind-1, value, dp);
        long pick = 0;
        if(coins[ind] <= value) pick = minCoins2(coins, ind, value - coins[ind], dp);

        return dp[ind][value] = notPick + pick;
    }
    public static long minCoins3(int[] coins, int value, long [][] dp){
        int n = coins.length;
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i <= value; i++) {
            if(i % coins[0] == 0) dp[0][i] = 1;
            else dp[0][i] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= value; j++) {
                long notPick = dp[i-1][j];
                long pick = 0;
                if(coins[i] <= j) pick = dp[i][j - coins[i]];

                dp[i][j] = notPick + pick;
            }
        }
        return dp[n-1][value];
    }
}
