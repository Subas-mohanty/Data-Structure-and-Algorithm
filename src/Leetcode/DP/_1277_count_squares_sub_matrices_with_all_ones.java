package Leetcode.DP;
//https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/?envType=daily-question&envId=2024-10-27

public class _1277_count_squares_sub_matrices_with_all_ones {

    // TC : O(m * n)
    // SC : O(m * n)
    // for each cell in the matrix we are counting how many square sub-matrices are possible and adding them all to get the answer
    Integer [][] dp = new Integer[301][301];
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                count += solve(i, j, matrix);
            }
        }
        return count;
    }
    int solve(int i, int j, int [][] matrix){
        // if out of bound we can't get any sub-matrices so returning 0
        if(i >= matrix.length || j >= matrix[0].length) return 0;
        if(matrix[i][j] == 0) return 0; // if the current cell value is 0, then also we can't make any sub-matrices because the matrices needs to have all one, and if we include the curr cell there will be no such sub-matrices

        if(dp[i][j] != null) return dp[i][j];
        // getting how many sub-matrices are possible from right, below and diagonal , taking the minimum of them and adding one for the single curr cell as it is 1 now
        int right = solve(i, j+1, matrix);
        int below = solve(i + 1, j, matrix);
        int diag = solve(i + 1, j+1, matrix);
        return dp[i][j] = 1 + Math.min(Math.min(right, below), diag);
    }
}
