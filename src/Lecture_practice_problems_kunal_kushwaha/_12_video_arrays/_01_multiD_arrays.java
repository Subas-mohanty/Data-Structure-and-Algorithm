package Lecture_practice_problems_kunal_kushwaha._12_video_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class _01_multiD_arrays {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //        int [][] arr ={
//                {1,2,3},
//                {4,5},
//                {6,7,8,9}
//        };
//        System.out.println(arr[0][1]);
//        System.out.println(arr[0].length);
//        System.out.println(arr.length);
        int [][] arr=new int[3][4];
        // for taking input
        for (int row = 0; row <arr.length; row++) {
            // for every row
            for (int col = 0; col <arr[row].length; col++) {
                arr[row][col]=sc.nextInt();
            }
        }
        // for taking output
        // method 1
//        for (int row = 0; row <arr.length; row++) {
//            // for every row
//            for (int col = 0; col <arr[row].length; col++) {  // --> here arr[row].length is used because size of every col is different
//                System.out.print(arr[row][col]+" ");
//            }
//            System.out.println();
//        }
        // method 2
//        for (int row = 0; row < arr.length; row++) {
//            System.out.println(Arrays.toString(arr[row]));
//        }

        // method 3
        for (int[] a:arr) {
            System.out.println(Arrays.toString(a));
        }
    }

}
