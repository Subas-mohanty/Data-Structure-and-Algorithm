package Lecture_practice_problems._13_linear_search;

import javax.swing.*;
import java.util.Arrays;

public class _03_search_in_2D_array {
    public static void main(String[] args) {
        int [][] arr={
                {23,45,67},
                {12,98,54},
                {34,27,778}
        };
        int target=78;
        int [] ans=search(arr,target); // format of return value {row,column}
        System.out.println(Arrays.toString(ans));

        System.out.println(max(arr));
    }
    static int[] search(int [][] arr,int target){
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                if(arr[row][column]==target){
                    return new int[]{row,column};
                }
            }
        }
        return new int []{-1,-1};
    }
    static int max(int [][] arr){
        int max=Integer.MIN_VALUE;
        for (int[] ints : arr) {
            for (int element : ints) {
                if (element > max) {
                    max = element;
                }
            }
        }
        return max;
    }
}
