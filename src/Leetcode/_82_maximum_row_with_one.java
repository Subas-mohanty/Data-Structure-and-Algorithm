package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//https://leetcode.com/problems/row-with-maximum-ones/
//https://shorturl.at/mxyQX
public class _82_maximum_row_with_one {
    public static void main(String[] args) {
        int n = 2;
        int m = 2;
        Scanner sc = new Scanner(System.in);

       int [][] matrix = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//               matrix[i][j] = sc.nextInt();
//            }
//        }

//        matrix[0][0] = 0;
//        matrix[0][1] = 0;
//        matrix[0][2] = 1;
//        matrix[0][3] = 1;
//        matrix[0][4] = 1;
//        matrix[1][0] = 0;
//        matrix[1][1] = 0;
//        matrix[1][2] = 0;
//        matrix[1][3] = 1;
//        matrix[1][4] = 1;
//        matrix[2][0] = 1;
//        matrix[2][1] = 1;
//        matrix[2][2] = 1;
//        matrix[2][3] = 1;
//        matrix[2][4] = 1;
//        matrix[3][0] = 0;
//        matrix[3][1] = 0;
//        matrix[3][2] = 0;
//        matrix[3][3] = 0;
//        matrix[3][4] = 0;
        matrix[0][0] = 0;
        matrix[0][1] = 1;
        matrix[1][0] = 1;
        matrix[1][1] = 0;
        System.out.println(maximumOnesRow2(matrix, n,m));
        System.out.println(Arrays.toString(rowAndMaximumOnes(matrix)));
    }
    public static int[] rowAndMaximumOnes(int [][] matrix){
        int noOfOnes = 0;
        int index = 0;
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i< n; i++){
            int count = 0;
            for(int j = 0; j< m; j++){
                if( matrix[i][j] == 1){
                    count++;
                    // we can't do this in leetcode as the matrix is not sorted
//                    count += m -j;
//                    break;
                }
            }
            if(count > noOfOnes){
                noOfOnes = count;
                index = i;
            }
        }
        return new int[]{index, noOfOnes};
    }
    public static int maximumOnesRow2(int [][] matrix, int n, int m){
        int noOfOnes = 0;
        int index = Integer.MAX_VALUE;

        for(int i = 0; i< n; i++){
            int count = 0;
            for(int j = 0; j< m; j++){
                if( matrix[i][j] == 1){
//                    count++;
                    count += m -j;
                    break;
                }
            }
            if(count > noOfOnes){
                noOfOnes = count;
                index = i;
            }
        }
        return index == Integer.MAX_VALUE ? -1 : index;
    }
    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m){
        int noOfOnes = 0;
        int index = Integer.MAX_VALUE;

        for(int i = 0; i< matrix.size(); i++){
            int count = 0;
            for(int j = 0; j<matrix.get(0).size(); j++){
                if(matrix.get(i).get(j) == 1) count++;
            }
            if(count > noOfOnes){
                noOfOnes = count;
                index = i;
            }
        }
        return index == Integer.MAX_VALUE ? -1 : index;
    }
}
