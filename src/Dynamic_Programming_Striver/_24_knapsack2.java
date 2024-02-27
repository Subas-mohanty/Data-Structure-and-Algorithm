package Dynamic_Programming_Striver;

import java.util.Arrays;
//https://bit.ly/3IvPdXS

public class _24_knapsack2 {
    public static void main(String[] args) {
        int [] wt = {7,2,4};
        int [] val = {5,10,20};
        int n = val.length;
        int bagWt = 15;
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
            if(wt[ind] <= bagWt) return bagWt/wt[ind]*val[ind]; // we can take the first element the number of times it divide the target , now to add its value we are multiplying it with its value
            else return 0;
        }
        int notPick = knapsack(wt, val, ind-1, bagWt);
        int pick = Integer.MIN_VALUE;
        if(wt[ind] <= bagWt) pick = val[ind] + knapsack(wt, val, ind, bagWt - wt[ind]);
        return Math.max(pick, notPick);
    }
    public static int knapsack2(int [] wt, int [] val, int ind, int bagWt, int [][] dp){
        if(ind == 0){
            if(wt[ind] <= bagWt) return bagWt/wt[ind]*val[ind];
            else return 0;
        }
        if(dp[ind][bagWt] != -1) return dp[ind][bagWt];
        int notPick = knapsack2(wt, val, ind-1, bagWt, dp);
        int pick = Integer.MIN_VALUE;
        if(wt[ind] <= bagWt) pick = val[ind] + knapsack2(wt, val, ind, bagWt - wt[ind], dp);
        return dp[ind][bagWt] = Math.max(pick, notPick);
    }
    public static int knapsack3(int [] wt, int [] val, int bagWt, int [][] dp){
        int n = wt.length;

        for (int i = 0; i <= bagWt; i++) {
            if (wt[0] <= i) dp[0][i] = i/wt[0] * val[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= bagWt; j++) {
                int notPick = dp[i-1][j];
                int pick = Integer.MIN_VALUE;
                if(wt[i] <= j) pick = val[i] + dp[i][j - wt[i]];
                dp[i][j] = Math.max(pick, notPick);
            }
        }
        return dp[n-1][bagWt];
    }
}
