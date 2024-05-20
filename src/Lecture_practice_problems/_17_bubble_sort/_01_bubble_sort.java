package Lecture_practice_problems._17_bubble_sort;

import java.util.Arrays;

public class _01_bubble_sort {
    public static void main(String[] args) {
//        int [] arr={1,2,3,4,5};
        int [] arr={2,0,2,1,1,0};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void bubble(int [] arr){
        boolean swapped=false;
        // run the steps n-1 times
        for (int i = 0; i < arr.length; i++) {
            // for each step,max item will come at last respective index
            for (int j = 1; j < arr.length-i; j++) {
                // swap if the item is smaller than the previous one
                if(arr[j]<arr[j-1]){
                    // swap algorithm
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    swapped=true;
                }
            }
            // if you did not swap for any particular value of it means the array is sorted hence not need to check again
            if (!swapped) { // when the swapped is false that means this does not go inside the loop so the array is sorted , so we break it after one check
                break;
            }
        }
    }

    static void bubbleSortRec(int [] arr,int i, int j){
        if (i == 0) {
            return;
        }
        if (j<i) {
            if(arr[j]>arr[j+1]){
                //swap
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
            bubbleSortRec(arr, i,j+1);
        } else{
            bubbleSortRec(arr, i-1,0);
        }
    }
}
