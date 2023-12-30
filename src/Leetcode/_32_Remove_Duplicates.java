package Leetcode;

import java.util.Arrays;

public class _32_Remove_Duplicates {
    public static void main(String[] args) {
        int [] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr));
    }
    public static int removeDuplicates(int[] arr) {
        int length = arr.length;
        if(length<=1){
            return length;
        }
        int index=0;
        for(int i =0 ;i < length-1;i++){
            if(arr[i]!=arr[i+1]){
                arr[index]=arr[i];
                index++;
            }
        }
        // for the last element
        arr[index]=arr[length-1];
        index++;
        return index;
    }
}
