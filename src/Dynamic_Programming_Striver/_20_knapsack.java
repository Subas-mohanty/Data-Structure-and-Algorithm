package Dynamic_Programming_Striver;

import java.util.Arrays;
//https://bit.ly/3KHpP3v

public class _20_knapsack {
    public static void main(String[] args) {
        int [] wt = {3,2,5};
        int [] val = {130,40,60};
        int n = val.length;
        int bagWt = 7;
        System.out.println(knapsack(wt, val, n-1, bagWt));

        int [][] dp = new int[n][bagWt+1];
        for(int [] a : dp){
            Arrays.fill(a, -1);
        }
        System.out.println(knapsack2(wt, val, n-1, bagWt, dp));

        int [][] Dp = new int[n][bagWt+1];
        System.out.println(knapsack3(wt, val,bagWt, Dp));
    }
    public static int knapsack(int [] wt, int [] val, int ind, int bagWt){
        if(ind == 0){
            if(wt[ind] <= bagWt) return val[ind];
            else return 0;
        }
        int notPick = knapsack(wt, val, ind-1, bagWt);
        int pick = Integer.MIN_VALUE;
        if(wt[ind] <= bagWt) pick = val[ind] + knapsack(wt, val, ind-1, bagWt - wt[ind]);
        return Math.max(pick, notPick);
    }
    public static int knapsack2(int [] wt, int [] val, int ind, int bagWt, int [][] dp){
        if(ind == 0){
            if(wt[ind] <= bagWt) return val[ind];
            else return 0;
        }
        if(dp[ind][bagWt] != -1) return dp[ind][bagWt];
        int notPick = knapsack2(wt, val, ind-1, bagWt, dp);
        int pick = Integer.MIN_VALUE;
        if(wt[ind] <= bagWt) pick = val[ind] + knapsack2(wt, val, ind-1, bagWt - wt[ind], dp);
        return dp[ind][bagWt] = Math.max(pick, notPick);
    }
    public static int knapsack3(int [] wt, int [] val, int bagWt, int [][] dp){
        int n = val.length;
        // at 0th index , if the element is smaller than the target or the bagWt we fill up all the index from first element value to the target/bagWt with val[0] , because if the target is greater than the first element than we have one option we can absolutely take it and that's why adding 0th value with the corresponding index
        for (int i = wt[0]; i <= bagWt; i++) {
            dp[0][i] = val[0];
        }
        for (int i = 1; i < n ; i++) {
            for (int j = 0; j <= bagWt ; j++) {
                int notPick = dp[i-1][j];
                int pick = Integer.MIN_VALUE;
                if(j >= wt[i]) pick = val[i] + dp[i-1][j-wt[i]];
                dp[i][j] = Math.max(pick, notPick);
            }
        }
        return dp[n-1][bagWt];
    }
}
