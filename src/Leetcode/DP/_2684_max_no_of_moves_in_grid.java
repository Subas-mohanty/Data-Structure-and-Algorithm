package Leetcode.DP;


// https://leetcode.com/problems/maximum-number-of-moves-in-a-grid/submissions/1437218610/?envType=daily-question&envId=2024-10-29

public class _2684_max_no_of_moves_in_grid {

    // TC : O(m * n)
    // SC : O(m * n)
    int m;
    int n;
    Integer [][] dp;
    public int maxMoves(int[][] grid) {
        int max = 0;
        n = grid.length;
        m = grid[0].length;
        dp = new Integer[n][m];
        // for each row position for the first col, finding the max move
        for(int i = 0; i < n; i++){
            max = Math.max(max, helper(grid, i, 0));
        }
        return max;
    }
    int helper(int [][] grid, int row, int col){
        // reach at the bottom right corner
        if(row == n-1 && col == m-1) return 0;
        int max = 0;
        
        if(dp[row][col] != null) return dp[row][col]; 

        for(int i = -1; i <= 1; i++){
            int newRow = row + i;
            int newCol = col+1;
            if(newRow >= n || newCol >= m || newRow < 0 || newCol < 0) continue;
            // moving to the next next if the next cell is strictly greater than current cell
            if(grid[newRow][newCol] > grid[row][col]){
                // adding 1 step and then taking the max
                max = Math.max(max, 1 + helper(grid, newRow, newCol));
            }
        }
        return dp[row][col] = max;
    }
}
