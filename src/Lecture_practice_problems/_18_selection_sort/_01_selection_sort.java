package Lecture_practice_problems._18_selection_sort;


import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.Arrays;

public class _01_selection_sort {
    public static void main(String[] args) {
        int [] arr={3,1,5,4,2};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void selectionSort(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            int last=arr.length-i-1;
            int max=getMax(arr,0,last); // max is the index of maximum element
            swap(arr,max,last);
        }
    }
    //swap function
    static void swap(int [] arr,int first, int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
    // function to get the maximum element
    public static int getMax(int[] arr, int start, int end) {
        int max=start;
        for (int i = start; i <=end ; i++) {
            if(arr[max]<arr[i]){
                max=i;
            }
        }
        return max;
    }
}
