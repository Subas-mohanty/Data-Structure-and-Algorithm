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
        return count(0, 0,grid, dp);
    }
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
}
