package Lecture_practice_problems._31_QuickSort;

import java.util.Arrays;

public class _01_QuickSort {
    public static void main(String[] args) {
        int [] arr={5,4,3,2,1};
//        sort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));;
        Arrays.sort(arr); // This is an inbuilt method for sorthing arrays
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int [] nums,int low,int high){
        // this the first violation condition , which means either the array is empty or indexes are wrongly passed
        if (low >= high) {
            return;
        }
        int start=low;
        int end=high;
        int mid=start+(end-start)/2;
        int pivot=nums[mid];

        while(start<=end){
            while(nums[start]<pivot){
                start++;
            }
            while(nums[end]>pivot){
                end--;
            }
            if (start <= end) {
                int temp=nums[start];
                nums[start]=nums[end];
                nums[end]=temp;
                start++;
                end--;
            }
        }
        sort(nums,low,end);
        sort(nums,start,high);
    }
}
