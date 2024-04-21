package Leetcode;

import java.util.ArrayList;
//https://shorturl.at/bqBL7
public class _83_kth_element_in_two_sorted_array {
    public static void main(String[] args) {

    }
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        int i=0, j = 0, ind=0;
        while(i < n && j <m){
            if(arr1.get(i) < arr2.get(j)){
                i++;
                ind++;
                if(ind == k) return arr1.get(i-1);
            }
            else{
                j++;
                ind++;
                if(ind == k) return arr2.get(j-1);
            }
        }
        while(i < n){
            i++;
            ind++;
            if(ind == k) return arr1.get(i-1);
        }
        while(j < m){
            j++;
            ind++;
            if(ind == k) return arr2.get(j-1);
        }
        return -1;
    }
}

