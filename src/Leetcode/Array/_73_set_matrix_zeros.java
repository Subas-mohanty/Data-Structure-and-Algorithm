package Leetcode.Array;
//https://leetcode.com/problems/set-matrix-zeroes/
public class _73_set_matrix_zeros {

    // brute force
    // TC : O(m * n * (m + n))
    // SC : O(m * n)
    // in brute force approach we can do another solution that traverse the matrix when we find a 0, mark it's rows and cols as -1, and do another iteration on the matrix, this time when you found -1, turn it into 0
    // it will be of constant space
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int [][] ans = new int[n][m];

        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m; j++){
                ans[i][j] = matrix[i][j];
            }
        }

        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 0){
                    for(int k = 0; k < n; k++){
                        ans[k][j] = 0;

//                        matrix[k][j] = -1; // for the alternate method i have written which use constant space
                    }
                    for(int k = 0; k < m; k++){
                        ans[i][k] = 0;

//                        matrix[k][j] = -1; // for the alternate method i have written which use constant space
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = ans[i][j];

                // for the alternate method i have written which use constant space
//                if(matrix[i][j] == -1){
//                    matrix[i][j] = 0
//                }
            }
        }
    }


    // better approach
    // TC : O(2*m*n)
    // SC : O(m + n)
    public void setZeroes2(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // store which and which col has a 0 in the matrix
        int[] row = new int[n];
        int[] col = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // when found a 0 at a cell, store its row and col in the array
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // reiterate in the matrix and check in the row and the col array if they are marked as 1(means at that index there was a 0), put 0 in the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    // optimal approach
    // TC : O(2*n*m + 2*(m+n)
    // SC : O(1)
    public void setZeroes3(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean first_row_flag = false;
        boolean first_col_flag = false;

        // checking if either first row or col has 0
        for(int i = 0; i < m; i++){
            if(matrix[0][i] == 0){
                first_row_flag = true;
                break;
            }
        }
        for(int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                first_col_flag = true;
                break;
            }
        }


        for(int i = 1; i < n; i++){
            for (int j = 1; j < m; j++) {
                if(matrix[i][j] == 0){
                    // if found a 0, mark its first col of the row(i) and first row of the col(j) as 0
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < n; i++){
            for (int j = 1; j < m; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    // if first col of i or first row of j is marked as 0, that means either i or j has a 0 in it, so mark the cell as 0
                    matrix[i][j] = 0;
                }
            }
        }

        // if first row had a 0 then mark all col of first row as 0
        if(first_row_flag){
            for (int i = 0; i < m; i++) {
               matrix[0][i] = 0;
            }
        }

        // if first col had a 0 then mark all row of first col as 0
        if(first_col_flag){
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
