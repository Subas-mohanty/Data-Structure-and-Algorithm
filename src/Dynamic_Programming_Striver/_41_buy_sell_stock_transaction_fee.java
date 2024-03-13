import java.util.Arrays;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
public class _41_buy_sell_stock_transaction_fee {
  public static void main(String[] args) {
    int [] arr = {1,3,2,8,4,9};
    int length = arr.length;
    int fee = 2;
    System.out.println(stock(arr, 1, 0, fee));

    
    int [][] dp = new int[length][2];
    for(int [] a : dp) Arrays.fill(a, -1);
    System.out.println(stock2(arr, 1, 0, fee, dp));


    int [][] Dp = new int[length+1][2];
    System.out.println(stock3(arr, 1, fee, Dp));

  }
  public static int stock(int [] arr, int canBuy, int i, int fee){
    if(i == arr.length) return 0;
    if(canBuy == 1){
      int buy = -arr[i] + stock(arr, 0, i+1, fee);
      int notBuy = stock(arr, 1, i+1, fee);
      return Math.max(buy, notBuy);
    }
    else{
      int sell = arr[i] - fee + stock(arr, 1, i+1, fee);
      int notSell = stock(arr, 0, i+1, fee);
      return Math.max(sell, notSell);
    }
  }

  public static int stock2(int [] arr, int canBuy, int i, int fee, int [][] dp){
    if(i == arr.length) return 0;
    if(dp[i][canBuy] != -1) return dp[i][canBuy];
    if(canBuy == 1){
      int buy = -arr[i] + stock2(arr, 0, i+1, fee, dp);
      int notBuy = stock2(arr, 1, i+1, fee, dp);
      return dp[i][canBuy] = Math.max(buy, notBuy);
    }
    else{
      int sell = arr[i] - fee + stock2(arr, 1, i+1, fee, dp);
      int notSell = stock2(arr, 0, i+1, fee, dp);
      return dp[i][canBuy] = Math.max(sell, notSell);
    }
  }

  public static int stock3(int [] arr, int canBuy, int fee, int [][] dp){
        int length = arr.length;
        dp[length][0] = dp[length][1] = 0;

        for(int i = length-1; i >= 0; i--){
            for(int j = 0; j <= 1; j++){
                int buy = -arr[i] + dp[i+1][0];
                int notBuy = dp[i+1][1];
                dp[i][1] = Math.max(buy, notBuy);

                int sell = arr[i] - fee + dp[i+1][1];
                int notSell = dp[i+1][0];
                dp[i][0] = Math.max(sell, notSell);
            }
        }
        return dp[0][1];
    }
}
