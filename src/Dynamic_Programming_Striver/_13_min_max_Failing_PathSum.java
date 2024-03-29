package Dynamic_Programming_Striver;
//https://leetcode.com/problems/minimum-falling-path-sum/
import java.util.Arrays;

public class _13_min_max_Failing_PathSum {
    public static void main(String[] args) {
        int [][] grid = {
                {11,3,2,6},
                {2,1,2,9},
                {4,8,2,4},
                {2,3,7,6},
        };
        int m = grid.length;
        int n = grid[0].length;
        int [][] dp = new int[m][n];

        for(int [] arr : dp){
            Arrays.fill(arr, -1);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            min= Math.min(min, sum(grid, 0, i, dp));
        }
        System.out.println(min);
        System.out.println(sum2(grid, dp));
    }
    // this is the memoization method but in some cases like this the memoization also gives TLE(Time Limit Exceed) error so, we have to do it using the tabulation method
    public static int sum(int [][] grid, int row, int col, int [][] dp){
        int m = grid.length;
        int n = grid[0].length;
        if(row == m-1) {
            return grid[row][col];
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int down = Integer.MAX_VALUE;
        int ld = Integer.MAX_VALUE;
        int rd = Integer.MAX_VALUE;
        if(row < m-1) down = grid[row][col] + sum(grid, row + 1, col, dp);
        if(row < m-1 && col > 0) ld = grid[row][col] + sum(grid, row+1, col-1, dp);
        if(row < m-1 && col < n-1)  rd = grid[row][col] + sum(grid, row+1, col+1, dp);

        return dp[row][col] = Math.min(down, Math.min(ld, rd));
    }
    public static int sum2(int [][] grid, int [][] dp){
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int down = grid[i][j] + dp[i-1][j];
                int ld = grid[i][j];
                if(j -1 >= 0){
                    ld += dp[i-1][j-1];
                }else {
                    // we can't add Integer.MAX_VALUE here because when we add it with something it goes to a very big negative number so that come as answer so we have to do something like this
                    ld += (int) Math.pow(10,9);
                }
                int rd = grid[i][j];
                if(j+1 < n){
                    rd += dp[i-1][j+1];
                }else{
                    rd += (int) Math.pow(10,9);
                }
                dp[i][j]= Math.min(down, Math.min(ld, rd));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[m-1][i]);
        }
        return min;
    }
}
