package Dynamic_Programming_Striver;

import java.util.Arrays;

//https://bit.ly/3rN7GIL
public class _36_buy_sell_stock {
    public static void main(String[] args) {
        int [] arr= {7,1,5,6,3,4};
        int length = arr.length;
        System.out.println(stock(arr, length-1));

        int [] dp = new int[length];
        Arrays.fill(dp, -1);
        System.out.println(stock2(arr, length-1, dp));

        System.out.println(stock3(arr));
    }
    public static int stock(int [] arr, int i){
        if(i == 0) return 0;

        int sell = arr[i];
        int min = (int) 1e9;
        for(int k = 0; k < i; k++){
            if(arr[k] < min) min = arr[k];
        }
        int ans = sell - min;
        return Math.max(ans, stock(arr, i-1));
    }
    public static int stock2(int [] arr, int i, int [] dp){
        if(i == 0) return 0;

        if(dp[i] != -1) return dp[i];
        int sell = arr[i];
        int min = (int) 1e9;
        for(int k = 0; k < i; k++){
            if(arr[k] < min) min = arr[k];
        }
        int ans = sell - min;
        return dp[i] = Math.max(ans, stock2(arr, i-1, dp));
    }
    public static int stock3(int [] arr){
        int min = arr[0]; // for first element the min value is the first element of the array
        int profit = 0; // and the profit is 0 , if we buy and sell on that day
        // traversing the array and on every element checking the max profit
        for (int j = 1; j < arr.length ; j++) {
            int diff = arr[j] - min;
            if(arr[j] < min) min = arr[j]; // updating the min
            profit = Math.max(profit, diff);
        }
       return profit;
    }
}