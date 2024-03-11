package Dynamic_Programming_Striver;

import java.util.Arrays;

public class _38_buy_and_sell_stock3 {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 0, 0, 3, 4};
        int length = arr.length;
        System.out.println(stock(arr, 0, 1, 2));

        int[][][] dp = new int[length][2][3];
        for (int[][] x : dp) {
            for (int[] a : x) Arrays.fill(a, -1);
        }
        System.out.println(stock2(arr, 0, 1, 2, dp));

        int[][][] Dp = new int[length+1][2][3];
        System.out.println(stock3(arr, 1, 2, Dp));
    }

    public static int stock(int[] arr, int i, int canBuy, int cap) {
        if (i == arr.length || cap == 0) return 0;

        // the cap is the number of times we can make the transaction
        if (canBuy == 1) {
            // we have two options either we buy it or not buy it
            int buy = -arr[i] + stock(arr, i + 1, 0, cap); // when we buy a stock we are not completing a transaction so the cap will remain same
            int notBuy = stock(arr, i + 1, 1, cap);
            return Math.max(buy, notBuy);
        } else {
            int sell = arr[i] + stock(arr, i + 1, 1, cap - 1); // one transaction got completed so reduced the cap by 1
            int notSell = stock(arr, i + 1, 0, cap);
            return Math.max(sell, notSell);
        }
    }

    public static int stock2(int[] arr, int i, int canBuy, int cap, int[][][] dp) {
        if (i == arr.length || cap == 0) return 0;

        // the cap is the number of times we can make the transaction
        if (dp[i][canBuy][cap] != -1) return dp[i][canBuy][cap];
        if (canBuy == 1) {
            // we have two options either we buy it or not buy it
            int buy = -arr[i] + stock2(arr, i + 1, 0, cap, dp); // when we buy a stock we are not completing a transaction so the cap will remain same
            int notBuy = stock2(arr, i + 1, 1, cap, dp);
            return dp[i][canBuy][cap] = Math.max(buy, notBuy);
        } else {
            int sell = arr[i] + stock2(arr, i + 1, 1, cap - 1, dp); // one transaction got completed so reduced the cap by 1
            int notSell = stock2(arr, i + 1, 0, cap, dp);
            return dp[i][canBuy][cap] = Math.max(sell, notSell);
        }
    }

    public static int stock3(int[] arr, int canBuy, int cap, int[][][] dp) {
        int n = arr.length;
//        for (int i = 0; i <= canBuy; i++) {
//            for (int j = 0; j <= cap; j++) {
//                dp[n][i][j] = 0;
//            }
//        }
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <= canBuy; j++) {
//                dp[i][j][0] = 0;
//            }
//        }
        // these above two cases we can omit as well as the initial value of all the elements in the dp array is 0

        for (int i = n-1; i >=0; i--) {
            for (int j = 0; j <= canBuy; j++) {
                for (int k = 1; k <= cap; k++) { // starting k or cap from 1 as we have written the base case for 0
                    if (j == 1) {
                        // we have two options either we buy it or not buy it
                        int buy = -arr[i] + dp[i+1][0][k]; // when we buy a stock we are not completing a transaction so the cap will remain same
                        int notBuy = dp[i+1][1][k];
                        dp[i][j][k] = Math.max(buy, notBuy);
                    } else {
                        int sell = arr[i] + dp[i+1][1][k-1];
                        int notSell = dp[i+1][0][k];
                        dp[i][j][k] = Math.max(sell, notSell);
                    }
                }
            }
        }
        return dp[0][canBuy][cap];
    }
}
