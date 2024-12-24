package Lecture_practice_problems_kunal_kushwaha._12_video_arrays;

import java.util.Arrays;

public class _04_array_swap {
    public static void main(String[] args) {
        int [] arr={45,54,12,78,178};
//        swap(arr,0,4);

        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void reverse(int [] arr){
        int start=0;
        int end=arr.length-1;
        while (start < end) {
            swap(arr,start,end);
            start++;
            end--;
        }
    }
    //    static int[] reverse(int [] arr){
//        for (int i = 0; i < (arr.length)/2; i++) {
//            int temp=arr[i];
//            arr[i]=arr[arr.length-i-1];
//            arr[arr.length-i-1]=temp;
//        }
////        for (int i = 0; i < arr.length; i++) {
////            System.out.print(arr[i]+" ");
////        }
//        return arr;
//    }
    static void swap(int[] arr,int index1,int index2){
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }
}
