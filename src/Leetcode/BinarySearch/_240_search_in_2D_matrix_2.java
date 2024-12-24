package Leetcode.BinarySearch;

//https://leetcode.com/problems/search-a-2d-matrix-ii/description/
public class _240_search_in_2D_matrix_2 {
    public static void main(String[] args) {
        int [][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        System.out.println(searchMatrix(matrix, target));
        System.out.println(optimal(matrix, target));
    }
    public static boolean optimal(int [][] matrix, int target){
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int col = m -1;

        while(row < n && col >= 0){
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }

    // TC : O(n*log m)
    // SC : O(1)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            boolean ans = findCol(matrix, target, i, 0, col-1);
            if(ans) return true;
        }
        return false;
    }
    public static boolean findCol(int [][] matrix, int target, int row, int cols, int cole){
        // binary search
        while(cols <= cole) {
            int mid = (cols+cole)/2;
            if(matrix[row][mid] == target) return true;
            if(matrix[row][mid] > target) cole = mid-1;
            else cols = mid+1;
        }
        return false;
    }
}
