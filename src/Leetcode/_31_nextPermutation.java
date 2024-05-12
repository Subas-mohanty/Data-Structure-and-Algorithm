package Leetcode;
import java.util.Arrays;

//https://leetcode.com/problems/next-permutation/submissions/1256103115/

public class _31_nextPermutation {

    public static void main(String[] args) {
        int [] arr = {4,2,0,2,3,2,0};
        // 4 2 0 3 2 2 0
//        int [] arr = {4,2,0,3,2,2,0};
        reverse(arr, 4);
//        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void nextPermutation(int[] arr) {
        int n = arr.length;
        int ind1 = -1;
        int ind2 = -1;

        for(int i = n-2; i >= 0; i--){
            if(arr[i] < arr[i+1]){
                ind1 = i;
                break;
            }
        }
        if(ind1 == -1) reverse(arr, 0);
        else {
            for(int i = n-1; i>=0; i--){
                if(arr[i] > arr[ind1]){
                    ind2 = i;
                    break;
                }
            }
            swap(arr, ind1, ind2);
            reverse(arr, ind1+1);
        }

    }
    public static void swap(int [] arr, int s, int e){
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }
    public static void reverse(int [] arr, int start){
        int i = start;
        int j = arr.length -1;
        while(i < j){
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}
