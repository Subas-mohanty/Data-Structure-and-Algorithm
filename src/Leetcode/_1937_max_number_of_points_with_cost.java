package Leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-number-of-points-with-cost/?envType=daily-question&envId=2024-08-17
//https://www.youtube.com/watch?v=0AlKD9rZfm4
public class _1937_max_number_of_points_with_cost {


    // TLE solution
    // TC : O(n * m * m)
    // SC : O(m * n) --> for the dp array
    public long maxPoints(int[][] points) {
        int n = points.length;
        int m = points[0].length;
        long ans = 0;
        long [][] dp = new long[n][m];
        for(long [] a : dp){
            Arrays.fill(a, -1);
        }
        for(int i = 0; i < m; i++){
            long max = helper(points, i, 0, dp);
            ans = Math.max(ans, max);
        }
        return ans;
    }
    public long helper(int [][] arr, int col, int row, long [][] dp){
        int n = arr.length;
        int m = arr[0].length;
        if(row == n-1) return arr[row][col];

        if(dp[row][col] != -1) return dp[row][col];

        long max = 0;
        for(int i = 0; i < m; i++){
            max = Math.max(max, helper(arr, i, row + 1, dp) - Math.abs(col - i));
        }
        return dp[row][col] = max + arr[row][col];
    }


    public long maxPoints4(int [][] points){
        int n = points.length;
        int m = points[0].length;
        long [] prev = new long[m];

        // Initialize first row
        for (int j = 0; j < m; j++) prev[j]=points[0][j];
        long [] curr = new long[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    curr[j] = Math.max(curr[j], points[i][j] - Math.abs(k - j));
                }
            }
            prev = curr;
        }
        // returns the max element in the prev array as long[orElseThrow()]
        return Arrays.stream(prev).max().orElseThrow();
    }

    // optimal solution
    // TC : O(m*n)
    // SC : O(m*n) optimized below
    public long maxPoints2(int[][] points) {
        int row = points.length;
        int col = points[0].length;
        long [][] dp = new long[row][col];

        for (int j = 0; j < col; j++) dp[0][j]=points[0][j];

        for(int i = 1; i < row; i++){
            long [] left = new long[col];
            left[0] = dp[i-1][0];
            for(int j = 1; j < col; j++){
                left[j] = Math.max(dp[i-1][j], left[j-1] - 1);
            }

            long [] right = new long[col];
            right[col-1] = dp[i-1][col-1];
            for(int j = col-2; j >= 0; j--){
                right[j] = Math.max(dp[i-1][j], right[j+1] - 1);
            }

            for(int j = 0; j < col; j++){
                dp[i][j] = points[i][j] + Math.max(left[j] , right[j]);
            }
        }
        long ans = 0;
        for(int i = 0; i < col; i++){
            ans = Math.max(ans, dp[row-1][i]);
        }
        return ans;
    }


    // TC : O(m*n)
    // SC : O(n)
    public long maxPoints3(int[][] points) {
        int row = points.length;
        int col = points[0].length;
        long [] prev = new long[col];

        // Initialize first row
        for (int j = 0; j < col; j++) prev[j]=points[0][j];

        for(int i = 1; i < row; i++){
            long [] left = new long[col];
            long [] right = new long[col];
            long [] curr = new long[col];

            // Fill left array
            left[0] = prev[0];
            for(int j = 1; j < col; j++){
                left[j] = Math.max(prev[j], left[j-1] - 1);
            }

            // Fill right array
            right[col-1] = prev[col-1];
            for(int j = col-2; j >= 0; j--){
                right[j] = Math.max(prev[j], right[j+1] - 1);
            }

            // Calculate current row's maximum points
            for(int j = 0; j < col; j++){
                curr[j] = points[i][j] + Math.max(left[j] , right[j]);
            }
            // Update prev array for the next iteration
            prev = curr;
        }

        // Return the maximum value from the last row
        long ans = 0;
        for(int i = 0; i < col; i++){
            ans = Math.max(ans, prev[i]);
        }
        return ans;
    }
}
