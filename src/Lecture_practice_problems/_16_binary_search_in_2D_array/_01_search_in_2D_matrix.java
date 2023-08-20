package Lecture_practice_problems._16_binary_search_in_2D_array;

import java.util.Arrays;

public class
_01_search_in_2D_matrix {
    public static void main(String[] args) {
        int [][] arr={
                {10,20,30},
                {12,24,32},
                {17,29,35}
        };
        int [] ans=searchIn2D(arr,29);
        System.out.println(Arrays.toString(ans));
    }
    static int [] searchIn2D(int [][] arr,int target){
        int row=0;
        int column=arr.length-1;
        while(row<arr.length && column>=0){
            if (arr[row][column] == target) {
                return new int[]{row,column};
            }
            else if(arr[row][column] > target){
                column--;
            }
            else{
                row++;
            }
        }
        return new int[]{-1,-1};
    }
}
