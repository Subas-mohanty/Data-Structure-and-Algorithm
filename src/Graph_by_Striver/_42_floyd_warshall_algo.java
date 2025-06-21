package Graph_by_Striver;

import java.util.Arrays;

public class _42_floyd_warshall_algo {
    public static void main(String[] args) {
        int [][] matrix = {
                {0,25},
                {-1,0}
        };
        shortest_distance(matrix);
        for(int [] a : matrix){
            for(int x : a){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    public static void shortest_distance(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // fill the matrix with a bigger value
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) { // means no path(given in question)
                    matrix[i][j] = (int)(1e9);
                }
                if (i == j) matrix[i][j] = 0;
            }
        }
        for(int [] a : matrix){
            for(int x : a){
                System.out.print(x + " ");
            }
            System.out.println();
        }
        // here is the actual algorithm
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        
        // the question asks if a path can't be reached then assign the value to -1
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == (int)1e9) matrix[i][j] = -1;
            }
        }
    }
}
