package Lecture_practice_problems._20_cyclic_sort;

import java.util.Arrays;
// we should use cyclic sort every single time if the elements are from 1 to N
public class _01_cyclic_sort {
    public static void main(String[] args) {
        int [] arr={2,1,3};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void cyclicSort(int [] arr){
        for (int i = 0; i < arr.length;) {
            if(i!=arr[i]-1){
                swap(arr,i,arr[i]-1); // here the correct index of ith element is arr[i]-1 cause the array is from 1 to N so every element must be present at N-1 index
            }else{
                i++;
            }
        }
    }
    static void swap(int[] arr, int first, int second) {
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
