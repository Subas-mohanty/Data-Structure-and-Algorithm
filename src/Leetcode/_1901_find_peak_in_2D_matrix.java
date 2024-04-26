package Leetcode;

import java.util.Arrays;
//https://leetcode.com/problems/find-a-peak-element-ii/description/
public class _1901_find_peak_in_2D_matrix {
    public static void main(String[] args) {
        int [][] mat = {
                {10,50,40,30,20},
                {1,500,2,3,4}
        };
//        System.out.println(Arrays.toString(findPeakGrid(mat)));
        System.out.println(Arrays.toString(findPeakGrid2(mat)));
    }

    // TC : O(m*log n)
    // SC : O(1)
    public static int[] findPeakGrid2(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = m - 1;

        // do binary search on col, on the mid col find the row which has the max value in that col, and check whether it is peak or not by checking it's left and right

        while (low <= high) {
            int mid = (low + high) / 2;
            int rowOfMaxEl = maxEl(mat, n, m, mid);
            int left = mid - 1 >= 0 ? mat[rowOfMaxEl][mid - 1] : -1;
            int right = mid + 1 < m ? mat[rowOfMaxEl][mid + 1] : -1;

            if (mat[rowOfMaxEl][mid] > left && mat[rowOfMaxEl][mid] > right)
                return new int[]{rowOfMaxEl, mid};
            else if (mat[rowOfMaxEl][mid] < left)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return new int[]{-1, -1};
    }

    public static int maxEl(int[][] mat, int n, int m, int col) {
        int maxi = -1;
        int ind = -1;
        for (int i = 0; i < n; i++) {
            if (mat[i][col] > maxi) {
                maxi = mat[i][col];
                ind = i;
            }
        }
        return ind;
    }

    // TC : O(m*n)
    // SC : O(1)
    public static int[] findPeakGrid(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                boolean ans = checkPeak(mat, i, j);
                if(ans) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    private static boolean checkPeak(int[][] mat, int i, int j) {
        int n = mat.length;
        int m = mat[0].length;

        boolean left = true;
        boolean right = true;
        boolean down = true;
        boolean up = true;

        if(i < n -1) down = mat[i][j] > mat[i+1][j];
        if(i > 0) up = mat[i][j] > mat[i-1][j];
        if(j < m-1) right = mat[i][j] > mat[i][j+1];
        if(j > 0) left =  mat[i][j] > mat[i][j-1];

        return left & right & up & down;
    }
}
