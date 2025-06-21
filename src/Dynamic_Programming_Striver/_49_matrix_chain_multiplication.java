package Dynamic_Programming_Striver;

import java.util.Arrays;
//https://bit.ly/3nXqfce
public class _49_matrix_chain_multiplication {
    public static void main(String[] args) {
//        int [] arr = {4,5,3,2};
        int [] arr = {10,20,30,40,50};
        int n = arr.length;

        System.out.println(MCM(arr, 1, n-1));

        int [][] dp = new int[n][n];
        for(int [] a : dp) Arrays.fill(a, -1);
        System.out.println(MCM2(arr, 1, n-1, dp));

        int [][] Dp = new int[n][n];
        System.out.println(MCM3(arr, Dp));
    }
    public static int MCM(int [] arr, int i, int j){
        if(i == j) return 0;

        int min =Integer.MAX_VALUE;
        for(int k = i; k < j ; k++){
            int steps = arr[i-1] * arr[k] * arr[j] + MCM(arr, i, k) + MCM(arr, k+1, j);
            min = Math.min(min, steps);
        }
        return min;
  }

  // TC : O(n*n) * n == O(n^3) , the extra n is for the loop
  // SC : O(n^2) + O(n) , for the dp and the recursion stack
  public static int MCM2(int [] arr, int i, int j, int [][] dp){
      if(i == j) return 0;

      if(dp[i][j] != -1) return dp[i][j];
      int min =Integer.MAX_VALUE;
      for(int k = i; k < j ; k++){
          int steps = arr[i-1] * arr[k] * arr[j] + MCM2(arr, i, k, dp) + MCM2(arr, k+1, j, dp);
          min = Math.min(min, steps);
      }
      return dp[i][j] = min;
  }
    public static int MCM3(int [] arr, int [][] dp){
        int n = arr.length;
//        for (int i = 0; i < n; i++) dp[i][i] = 0; // don't need as the dp is initialized with 0 by default

        for (int i = n-1; i >= 1; i--) {
            for (int j = i+1; j < n; j++) {
                int min = (int)1e9;
                for(int k = i; k < j ; k++){
                    int steps = arr[i-1] * arr[k] * arr[j] + dp[i][k] + dp[k+1][j];
                    min = Math.min(min, steps);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n-1];
   }
}
