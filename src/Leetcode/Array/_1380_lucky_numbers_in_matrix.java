package Leetcode.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/

public class _1380_lucky_numbers_in_matrix {

    // TC : O(2 * m * n)
    // SC : O(1)
    public static List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> list = new ArrayList<>(1);
        // only one answer is present
        // https://gist.github.com/Subas-mohanty/938fe5f858f9f8c466cf0bdfd2356dab
        int checkMin = 0;

        // finding min for every col and getting the max of them
        for(int i = 0; i < n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < m; j++){
                if(matrix[i][j] < min) min = matrix[i][j];
            }
            if(min > checkMin) checkMin = min;
        }

        // checking if the checkMin or the answer that we got is correct or not
        for(int col = 0; col < m; col++){
            int max = 0;
            for(int row = 0; row < n; row++){
                max = Math.max(max, matrix[row][col]);
            }
            if(max == checkMin) list.add(max);
        }
        return list;
    }


    // TC : O(3 * m * n)
    // SC : O(2 * n)
    public static List<Integer> luckyNumbers2 (int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i = 0; i < n; i++){
            set1.add(checkRow(matrix, i));
        }
        for(int i = 0; i < m; i++){
            set2.add(checkCol(matrix, i));
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int check = matrix[i][j];
                if(set1.contains(check) && set2.contains(check)) list.add(check);
            }
        }
        return list;
    }
    public static int checkRow(int[][] matrix, int row){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[row][i] < min) min = matrix[row][i];
        }
        return min;
    }
    public static int checkCol(int[][] matrix, int col){
        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][col] > max) max = matrix[i][col];
        }
        return max;
    }




    // TC : O(m * n * (m+n))
    // SC : O(1)
    public static List<Integer> luckyNumbers3 (int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                boolean min = checkRow(matrix, matrix[i][j], i);
                boolean max = checkCol(matrix, matrix[i][j], j);
                if(min && max) list.add(matrix[i][j]);
            }
        }
        return list;
    }
    public static boolean checkRow(int[][] matrix, int check, int row){
        int min = check;
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[row][i] < check) min = matrix[row][i];
        }
        return check == min;
    }
    public static boolean checkCol(int[][] matrix, int check, int col){
        int max = check;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][col] > check) max = matrix[i][col];
        }
        return check == max;
    }
}
