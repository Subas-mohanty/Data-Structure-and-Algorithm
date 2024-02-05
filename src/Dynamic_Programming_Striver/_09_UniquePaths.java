package Dynamic_Programming_Striver;

import java.util.Arrays;

//https://leetcode.com/problems/unique-paths/description/
public class _09_UniquePaths {
  public static void main(String[] args) {
    
  }
  // TC - 2^m*n
  // SC - O(row + col)
  static int count(int row, int col){
    if (row == 0 || col == 0) {
      return 1;
    }
    int left=count(row-1,col);
    int right=count(row,col-1);
    return left+right;
  }

  // memoization
  // m and n are the size of the matrix
  // TC - O(m*n)
  // SC - O(row + col) -> for recursion stack + O(m*n) -> for dp array
  public static int uniquePaths(int m, int n) {
    int [][] dp= new int[m][n];
    for(int [] row : dp){
      Arrays.fill(row, -1);
    }
    return count(m-1, n-1, dp);
  }
  static int count(int row, int col, int [][] dp){
    if (row == 0 || col == 0) {
      return 1;
    }
    if(dp[row][col] != -1){
      return dp[row][col];
    }
    int down=count(row-1,col, dp);
    int right=count(row,col-1, dp);

	return dp[row][col] = down + right;
    }

  // TC -: O(m*n)
  // SC -: O(m*n) -> only for the dp array
  static int count2(int row, int col, int [][] dp){
    dp[0][0]= 0;

    for (int i = 0; i <= row; i++) {
      for (int j = 0; j <= col; j++) {
        if( i == 0 && j == 0){
          dp[0][0] = 0;
        }
        else{
          int down = 0;
          int right = 0;
          if(i>0) down = dp[i-1][j];
          if(j>0) right = dp[i][j-1];
          dp[i][j] = down + right;
        }
      }
    }
    return dp[row][col];
  }
}
