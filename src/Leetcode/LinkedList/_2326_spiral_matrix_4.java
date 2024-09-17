package Leetcode.LinkedList;

import java.util.Arrays;
//https://leetcode.com/problems/spiral-matrix-iv/?envType=daily-question&envId=2024-09-09
public class _2326_spiral_matrix_4 {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];

        for(int [] a : matrix) Arrays.fill(a, -1);
        int top=0;
        int left=0;
        int bottom=matrix.length-1;
        int right=matrix[0].length-1;

        while(head != null && left<=right && top<=bottom){


            // printing top row for left to right
            for(int i=left;i<=right && head != null;i++){
                matrix[top][i] = head.val;
                head = head.next;
            }
            // after printing the first row move the row to one line down
            top++;

            // printing top to bottom

            for(int i=top;i<=bottom && head != null; i++){
                matrix[i][right] = head.val;
                head = head.next;
            }
            right--;

            // if only one row or one column is present
            if(top<=bottom){
                for(int i=right;i>=left && head != null;i--){
                    matrix[bottom][i] = head.val;
                    head = head.next;
                }
                bottom--;
            }

            if(left<=right){
                for(int i=bottom;i>=top && head != null;i--){
                    matrix[i][left] = head.val;
                    head = head.next;
                }
                left++;
            }
        }
        return matrix;
    }
}
