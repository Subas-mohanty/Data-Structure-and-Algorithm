package Lecture_practice_problems._19_insertion_sort;

import java.util.Arrays;

public class _01_insertion_sort {
    public static void main(String[] args) {
        int [] arr={3,1,5,4,2};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void insertionSort(int[] arr){
        //  3 1 5 4 2
        // first i=0 and j=1, and it checks whether 1 is less than 3 or not and it will say yes it is true then in the if block it will swap these two values will be swapped and same will continue but when the j value is greater than j-1 it will break cause it knows that no element greater than this will be present on the left hand side. And the j loop will decrease until its value reach to one means start of the array
        // i will not run till last index. because if i becomes 4 then j will become 5 which will give index out of bound exception and another point is , i doesn't need to be gone till last index as the array get sorted when i, is at second last index so no need to check again for the last index
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j >0 ; j--) {
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                } else{
                    break;
                }
            }
        }
    }
    static void swap(int[] arr, int first, int second) {
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
