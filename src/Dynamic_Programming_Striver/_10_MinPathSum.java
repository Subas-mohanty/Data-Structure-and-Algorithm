package Dynamic_Programming_Striver;

import java.util.Arrays;
//https://leetcode.com/problems/minimum-path-sum/description/
public class _10_MinPathSum {
    public static void main(String[] args) {
        int [][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(minPathSum(grid));
    }
    public static int minPathSum(int [][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] dp= new int[m][n];
        for(int [] row : dp){
            Arrays.fill(row, -1);
        }
//        return count(0, 0,grid, dp);
        return count2(m-1, n-1, grid, dp);
    }
    // memoization
    // Tabulation method
    // TC : O(m*n)
    // SC : O(m*n) + O(m*n) recursion stack + space for the dp array
    static int count(int row, int col,int [][] grid, int [][] dp){
        if (row == grid.length-1 && col == grid[0].length-1) {
            return grid[row][col];
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int right =Integer.MAX_VALUE;
        int down =Integer.MAX_VALUE;
        if(col<grid[0].length-1){
            right = grid[row][col] + count( row, col+1,grid, dp);
        }
        if(row<grid.length-1){
            down = grid[row][col] + count( row +1, col,grid, dp);
        }
        return dp[row][col] = Math.min(down, right);
    }
    // Tabulation method
    // TC : O(m*n)
    // SC : O(m*n) only the dp array space no recursion stack space
    static int count2(int row, int col,int [][] grid, int [][] dp){
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                if(i == 0 &&  j==0) {
                    dp[0][0] = grid[0][0];
                }
                else{
                    int left = Integer.MAX_VALUE;
                    int up = Integer.MAX_VALUE;
                    if(j > 0) left = grid[i][j] + dp[i][j-1];
                    if(i > 0) up = grid[i][j] + dp[i-1][j];
                    // we are storing the answer of each index of the grid in the dp array. For Ex- the answer for grid[1][2] will be at dp[1][2]
                    dp[i][j] = Math.min(left, up);
                }
            }
        }
        // the final answer will be at dp[row][col]
        return dp[row][col];
    }
}
