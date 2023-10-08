package Lecture_practice_problems._12_video_arrays;

import java.util.Arrays;
import java.util.Collections;

public class _05_max_element_of_array {
    public static void main(String[] args) {
        int [] arr={45,54,12,78,178};
        System.out.println(max(arr));
        System.out.println(maxInRange(arr,1,3));

        // this will sort the array in reverse order but the arr should be of wrapper class, i.e, Integer [] arr= new Integer[];
        //Arrays.sort(arr, Collections.reverseOrder());
    }

    // check the maximum value in the given range of the array
    static int maxInRange(int[] arr,int range1,int range2) {
        int max=0;
        for (int i = range1; i < range2; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return  max;
    }
    // check the maximum value in the array
    static int max(int[] arr) {
        int max=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return  max;
    }
}
