package Leetcode;
//https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/?envType=daily-question&envId=2024-05-30

import java.util.*;
//https://chatgpt.com/c/5b3de9ce-3090-48d2-846b-cf72563d680e
// explanation for countTriplets3 function, why ans += (j-i)
public class _1442_countTriplets {
    public static void main(String[] args) {
        int [] arr = {1,1,1,1,1};
        System.out.println(countTriplets(arr));
        System.out.println(countTriplets2(arr));
        System.out.println(countTriplets3(arr));
    }

    // TC : O(n^2)
    // SC : O(1)
    public static int countTriplets3(int [] arr){
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int xor = arr[i];
            for (int j = i+1; j < n; j++) {
               xor ^= arr[j];
               if(xor == 0){
                   count += (j-i);
               }
            }
        }
        return count;
    }

    // O(n^3)
    // O(1)
    public static int countTriplets2(int[] arr) {
        int n = arr.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int a = 0, b = 0;
                for(int k = i; k < j; k++) a ^= arr[k];
                for(int k = j; k < n; k++){
                    b ^= arr[k];
                    if(a ==b) count++;
                }
            }
        }
        return count;
    }

    // TC : O(n^4)
    // SC : O(1)
    public static int countTriplets(int[] arr) {
        int n = arr.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                for(int k = j; k < n; k++){
                    int a = find(arr, i, j-1);
                    int b = find(arr, j, k);
                    if(a ==b) count++;
                }
            }
        }
        return count;
    }
    static int find(int [] arr, int s, int e){
        int xor = arr[s];
        for(int i = s+1; i <= e; i++){
            xor ^= arr[i];
        }
        return xor;
    }
}