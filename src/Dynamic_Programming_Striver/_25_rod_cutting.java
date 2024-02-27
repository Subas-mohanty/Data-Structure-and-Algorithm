package Dynamic_Programming_Striver;

import java.util.Arrays;

//https://bit.ly/3H10kYJ
// the problem is same as of knapsack but here the weight is ind+1 of the index and the value of the price is the element of the array
public class _25_rod_cutting {
    public static void main(String[] args) {
        int [] wt = {42, 68, 35, 1, 70, 0};
        int n = wt.length;
        int bagWt = 8;
        System.out.println(rodCutting(wt, n-1, bagWt));

        int [][] dp = new int[n][bagWt+1];
        for(int [] a : dp){
            Arrays.fill(a, -1);
        }
        System.out.println(rodCutting2(wt, n-1, bagWt, dp));

        int [][] Dp = new int[n][bagWt+1];
        System.out.println(rodCutting3(wt,bagWt, Dp));
    }
    public static int rodCutting(int [] price, int ind, int target){
        int rodLength = ind+1;
        if(ind == 0){
            if(rodLength<= target) return target*price[0];
            else return 0;
        }
        int notPick = rodCutting(price, ind-1, target);
        int pick = Integer.MIN_VALUE;
        if(rodLength <= target) pick = price[ind] + rodCutting(price, ind, target - rodLength);
        return Math.max(pick, notPick);
    }
    public static int rodCutting2(int [] price, int ind, int target, int [][] dp){
        int rodLength = ind+1;
        if(ind == 0){
//            if(rodLength <= target) return target*price[0];
//            else return 0;
            return target*price[0]; // we can directly write like this because for index ==0 the value of rodLength will be 1, and it satisfies for all condition and as said in the question the roadLength is ind+1 so the rodLength can't be 0
        }
        if(dp[ind][target] != -1) return dp[ind][target];
        int notPick = rodCutting2(price, ind-1, target, dp);
        int pick = Integer.MIN_VALUE;
        if(rodLength <= target) pick = price[ind] + rodCutting2(price, ind, target - rodLength, dp);
        return dp[ind][target] = Math.max(pick, notPick);
    }
    public static int rodCutting3(int [] price, int target, int [][] dp){
        int n = price.length;
        for (int i = 0; i <= target; i++) {
             dp[0][i] = i * price[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                int notPick = dp[i-1][j];
                int pick = Integer.MIN_VALUE;
                int rodLength = i + 1;
                if(rodLength <= j) pick = price[i] + dp[i][j - rodLength];
                dp[i][j] = Math.max(pick, notPick);
            }
        }
        return dp[n-1][target];
    }
}
