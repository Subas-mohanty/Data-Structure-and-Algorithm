package Dynamic_Programming_Striver;

import java.util.Arrays;

//https://leetcode.com/problems/unique-paths/description/
public class _09_UniquePaths {
  public static void main(String[] args) {
    int m = 5;
    int n = 2;
    System.out.println(uniquePaths(m,n));
  }
  // Normal Recursion
  // TC - 2^m*n, we have 2 possibilities for each element of the grid
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
    System.out.println(count2(m, n, dp));
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

//    Tabulation
//    TC -: O(m*n)
//    SC -: O(m*n) -> only for the dp array
  static int count2(int row, int col, int [][] dp){
    // take the loop on the changing parameters for eg- row and col
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if( i == 0 && j == 0){ // we can't do something like this i == 0 || j== 0 if we do so, the below down and right assignment will be wrong
          dp[0][0] = 1; // base case
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
    return dp[row-1][col-1]; // as we are taking row and col as the length not the index so, we have to do the -1 thing, but look at the count function here we are taking row and col as the index so no need to do -1
  }
}
