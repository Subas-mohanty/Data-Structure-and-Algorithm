package Lecture_practice_problems._29_Recursion_04;

import java.util.Arrays;

public class _01_TrianglePattern {
    public static void main(String[] args) {
//        pattern(4,0);
//        pattern2(4,0);
//        int [] arr={4,3,2,1};
//        bubble(arr,arr.length-1,0);
//        System.out.println(Arrays.toString(arr));

        int [] arr={4,2,3,1};
        selection(arr,arr.length,0,0);
        System.out.println(Arrays.toString(arr));
    }
    static void pattern(int r,int c){
        if (r == 0) {
            return;
        }
        if (c<r) {
            System.out.print("*");
            pattern(r,c+1);
        } else{
            System.out.println();
            pattern(r-1,0);
        }
    }

    static void pattern2(int r,int c){
        if (r == 0) {
            return;
        }
        if (c<r) {
            pattern2(r,c+1);
            System.out.print("*");
        } else{
            pattern2(r-1,0);
            System.out.println();
        }
    }

    static void bubble(int [] arr,int r,int c){
        if (r == 0) {
            return;
        }
        if (c<r) {
            if(arr[c]>arr[c+1]){
                //swap
                int temp=arr[c];
                arr[c]=arr[c+1];
                arr[c+1]=temp;
            }
            bubble(arr, r,c+1);
        } else{
            bubble(arr, r-1,0);
        }
    }

    static void selection(int [] arr,int r,int c,int max){ // r is the length of the array
        if (r == 0) {
            return;
        }
        if (c<r) {
            if(arr[c]>arr[max]){
                selection(arr,r,c+1,c);
            }else{
                selection(arr, r,c+1,max);
            }
        } else{
            //swap
            int temp=arr[max];
            arr[max]=arr[r-1];
            arr[r-1]=temp;
            selection(arr, r-1,0,0);
        }
    }
}
