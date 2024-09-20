package Leetcode;

import java.util.List;
//https://leetcode.com/problems/find-a-safe-walk-through-a-grid/description/

public class _3286_find_safe_walk_in_grid {
    int n;
    int m;
    int [][][] dp;
    // TC : O(4 * n* m)
    // SC : O(m*n*health)
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        n = grid.size();
        m = grid.get(0).size();
        dp = new int[n][m][health+1];

        return helper(0, 0, health, grid, new boolean[n][m]);
    }
    boolean helper(int row, int col, int health, List<List<Integer>> grid, boolean [][] vis){
        // if at any point health get 0 than we can't reach at the destination
        if(health <= 0) return false;

        // if we are at the last index, check if the element at that index is 1 or 0, if 1, reduce the health and return the answer
        if(row == n-1 && col == m-1){
            if (grid.get(row).get(col) == 1) health--;  // Deduct health if the last cell is unsafe
            return health > 0;
        }
        // out of bound case
        if(row >= n || row < 0 || col >= m || col < 0) return false;

        // if the current element is 1 then reduce health by 1
        if(grid.get(row).get(col) == 1) health -= 1;

        // if the current cell is visited then no need to visit its neighbour again
        if(vis[row][col]) return false;

        // memoization
        if(dp[row][col][health] == 1) return true;
        if(dp[row][col][health] == 2) return false;

        vis[row][col] = true;

        // visiting all the 4 direction to get the answer
        boolean result = helper(row-1, col, health, grid, vis) || helper(row+1, col, health, grid, vis) || helper(row, col+1, health, grid, vis) || helper(row, col-1, health, grid, vis);

        vis[row][col] = false;
        dp[row][col][health] = result ? 1 : 2;
        return result;
    }
}
