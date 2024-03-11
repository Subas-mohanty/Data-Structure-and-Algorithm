package Dynamic_Programming_Striver;

import java.util.Arrays;

public class _40_buy_and_sell_stock_cooldown {
    public static void main(String[] args) {
        int [] arr = {4,9,0,3,10};
        int length = arr.length;
        System.out.println(stock(arr, 0, 1));


        int [][] dp = new int[length][2];
        for(int [] a : dp) Arrays.fill(a, -1);
        System.out.println(stock2(arr, 0, 1, dp));

        int [][] Dp = new int[length+2][2];
        System.out.println(stock3(arr, 1, Dp));
    }
    public static int stock(int [] arr, int i, int canBuy){
        // if we sell something but not bought it and the index goes out of bound we have to bought the first element so this will be subtracted or it's negative will be added to profit
//        if(i == arr.length) return 0;
        if(i >= arr.length) return 0;
        if(canBuy == 1){
            int buy = -arr[i] + stock(arr, i+1, 0);
            int notBuy = stock(arr, i+1, 1);
            return Math.max(buy, notBuy);
        }
        else{
//            int sell;
//            if(i == arr.length-1) sell = arr[i] + stock(arr, i+1, 1);
//            else sell = arr[i] + stock(arr, i+2, 1);
            int sell = arr[i] + stock(arr, i+2, 1);
            int notSell = stock(arr, i+1, 0);
            return Math.max(sell, notSell);
        }
    }
    public static int stock2(int [] arr, int i, int canBuy, int [][] dp){
        if(i >= arr.length) return 0;

        if(dp[i][canBuy] != -1) return dp[i][canBuy];
        if(canBuy == 1){
            // profit = sell - buy
            // this buy and notBuy is actually the profit if we make the decision of buy and not buy
            // so when we bought something our total value will be subtracted by that value and when we sell something this value will be added to our total value
            int buy = -arr[i] + stock2(arr, i+1, 0, dp);
            int notBuy = stock2(arr, i+1, 1, dp);
            return dp[i][canBuy] = Math.max(buy, notBuy);
        }
        else{
            int sell = arr[i] + stock2(arr, i+2, 1, dp);
            int notSell = stock2(arr, i+1, 0, dp);
            return dp[i][canBuy] = Math.max(sell, notSell);
        }
    }
    public static int stock3(int [] arr, int canBuy, int [][] dp){
        int n = arr.length;
        dp[n][0] = dp[n][1] = 0; // when index == arr.length our profit is 0 no matter we buy it or sell it
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                // we can omit this inside for loop as well , because we know that if j == 1 then our if statement will run and when j = 0 our else statement will be run. so instead of writing dp[i][j] we can write dp[i][1] and dp[i][0] for the respective case
                if(j == 1){
                    int buy = -arr[i] + dp[i+1][0];
                    int notBuy = dp[i+1][1];
                    dp[i][j] = Math.max(buy, notBuy);
                }
                else{
                    int sell = arr[i] + dp[i+2][1]; // this will go index out of bound so declare the dp array as length+2
                    int notSell = dp[i+1][0];
                    dp[i][j] = Math.max(sell, notSell);
                }
            }
        }
        return dp[0][1];
    }
}
