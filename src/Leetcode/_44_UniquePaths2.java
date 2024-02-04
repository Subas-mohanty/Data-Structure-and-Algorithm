package Leetcode;

import java.util.Arrays;
//https://leetcode.com/problems/unique-paths-ii/
public class _44_UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] maze) {
        int row = maze.length;
        int col = maze[0].length;
        int [][] dp = new int[row][col];
        for(int [] arr : dp){
            Arrays.fill(arr, -1);
        }
        return helper(maze, 0, 0, dp);
    }
    public int helper(int[][] maze, int row, int col, int[][] dp){
        if(maze[row][col] == 1){
            return 0;
        }
        if(row == maze.length-1 && col == maze[0].length - 1){
            return 1;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int right =0;
        int down =0;
        if(col<maze[0].length-1){
            right = helper(maze, row, col+1, dp);
        }
        if(row<maze.length-1){
            down = helper(maze , row +1, col, dp);
        }

        return dp[row][col] = right+down;
    }
}
