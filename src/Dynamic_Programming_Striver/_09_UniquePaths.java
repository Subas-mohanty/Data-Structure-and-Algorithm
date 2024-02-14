package Dynamic_Programming_Striver;

import java.util.Arrays;

//https://leetcode.com/problems/unique-paths/description/
public class _09_UniquePaths {
  public static void main(String[] args) {
    int m = 5;
    int n = 2;
    System.out.println(uniquePaths(m,n));
    System.out.println(count3(m, n));
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

  // Space optimization
  // TC -: O(m*n)
  // SC -: O(n) --> for the prev and the temp array
  static int count3(int row, int col){
    // this is for the previous row , i.e, we are storing answer for all the columns for the previous row that we are currently calculating
    int [] prev = new int[col]; // number of columns in the grid/matrix

    for (int i = 0; i < row; i++) {
      // this is for the current row, the row that we want to calculate, storing the value so that we can calculate the current index using the left/right of it
      int [] temp = new int[col];
      for (int j = 0; j < col; j++) {
        if( i == 0 && j == 0){
          temp[j] = 1;
        }
        else{
          int up = 0;
          int left = 0;
          if(i>0) up = prev[j]; // for up the value for previous row has been calculated and stored in prev array so use that for the jth col
          if(j>0) left = temp[j-1]; // for left the value is calculated and stored in the temp array at the j-1st col so use that
          temp[j] = up + left;
        }
      }
      prev = temp; // updating prev to temp, after completion of one row we are making the prev as temp that means the prev array move 1 step down
    }
    return prev[col-1]; // the final answer will be at the last row which is previous and the last col that is passed
  }
}
