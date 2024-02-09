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
        System.out.println(sum(grid, 0, 0, dp));
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
}
