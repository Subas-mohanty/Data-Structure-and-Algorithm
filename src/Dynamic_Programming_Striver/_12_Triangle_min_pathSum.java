package Dynamic_Programming_Striver;

import java.util.Arrays;
//https://www.codingninjas.com/studio/problems/triangle_1229398?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=SUBMISSION
public class _12_Triangle_min_pathSum{
    public static void main(String[] args) {
        int [][] grid = {
//                {3},
                {5},
                {-1,3},
                {22,1,-9}
        };
        int m = grid.length;
        int n = grid[m-1].length;
        int [][] dp = new int[m][n];
        for(int [] arr: dp){
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
//        System.out.println(sum(grid, 0, 0, dp));
        System.out.println(sum2(grid, m, n, dp));
    }
    public static int sum(int [][] grid, int row, int col, int [][] dp){
        if(row == grid.length-1){
            return grid[row][col];
        }
        if(dp[row][col] != Integer.MIN_VALUE){
            return dp[row][col];
        }
        int down = Integer.MAX_VALUE;
        int diag = Integer.MAX_VALUE;
        if(row < grid.length -1) down = grid[row][col] + sum(grid, row + 1, col, dp);
        if(row+1 < grid.length && col < grid[row+1].length-1) diag = grid[row][col] + sum(grid, row + 1, col + 1, dp);

        return dp[row][col] = Math.min(down, diag);
    }
    // tabulation doesn't mean always starts from 0 , instead if the recursion is starting from 0 then the tabulation should be start from length-1, it will always be opposite to recursion because recursion is always top down
    public static int sum2(int [][] grid, int row, int col, int [][] dp) {
        for (int i = 0; i < row; i++) {
            dp[row - 1][i] = grid[row - 1][i];
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = grid[i][j] + dp[i + 1][j];
                int diag = grid[i][j] + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, diag);
            }
        }
        return dp[0][0];
    }
}
