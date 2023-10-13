package Leetcode;
import java.util.ArrayList;
import java.util.List;


//https://leetcode.com/problems/spiral-matrix/
public class _21_Spiral_matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top=0;
        int left=0;
        int bottom=matrix.length-1;
        int right=matrix[0].length-1;
        List<Integer> list=new ArrayList<>();

        while(left<=right && top<=bottom){

            for(int i=left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            top++;

            for(int i=top;i<=bottom;i++){
                list.add(matrix[i][right]);
            }
            right--;

            // if only one row or one column is present
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }
}
