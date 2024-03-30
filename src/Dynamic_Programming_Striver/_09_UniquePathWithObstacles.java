package Dynamic_Programming_Striver;
//https://leetcode.com/problems/unique-paths-ii/description/
public class _09_UniquePathWithObstacles {
    public static void main(String[] args) {
        int [][] grid = {
                {0,0},
                {0,0}
        };
        System.out.println(helper(0,0,grid));
        System.out.println(helper2(grid));
    }
    public static int helper2(int [][] grid){
        int n = grid.length;
        int m = grid[0].length;


        int [][] dp = new int[n][m];

        for(int i = n-1; i >=0; i--){
            for(int j = m-1; j>=0; j--){

                if(i == n-1 && j == m-1) dp[n-1][m-1] = 1;
                else{
                    int right = 0;
                    int down = 0;
                    if(i < n-1 && grid[i][j] != 1)right = dp[i+1][j];
                    if(j < m-1 && grid[i][j] != 1) down = dp[i][j+1];
                    dp[i][j] = right + down;
                }

            }
        }

        // if the destination is an obstacle then we don't have any path to reach there
        if(grid[n-1][m-1] == 1) return 0;
        return dp[0][0];
    }
    public static int helper(int n, int m, int [][] grid){
        if(n == grid.length-1 && m == grid[0].length-1) return 1;

        int right = 0;
        int down = 0;
        // if(grid[n][m] == 1) return 0;
        if(n < grid.length-1 && grid[n][m] != 1)right = helper(n+1, m, grid);
        if(m < grid[0].length-1 && grid[n][m] != 1) down = helper(n, m+1, grid);

        return right + down;
    }
}
