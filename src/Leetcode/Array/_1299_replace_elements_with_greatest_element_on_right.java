package Leetcode.Array;

import java.util.ArrayList;
import java.util.Collections;
//https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/description/
//https://shorturl.at/EGIZ0
public class _1299_replace_elements_with_greatest_element_on_right {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,0};
        System.out.println(leaders(arr, arr.length));
    }
    static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[n-1]);
        for(int i = n-2; i >=0 ; i--){
            int max = 0;
            for(int j = n-1; j >= i; j--){
                max  = Math.max(max, arr[j]);
            }
            if(max == arr[i]) ans.add(arr[i]);
        }
        Collections.reverse(ans);
        return ans;
    }

    // TC : O(n^2)
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int max = -1;
            for (int j = i+1; j < n; j++) {
                max = Math.max(max, arr[j]);
            }
            arr[i] = max;
        }
        return arr;
    }

    // TC : O(n)
    public int[] replaceElements2(int[] arr) {
        int n = arr.length;

        int max = -1;
        for(int i = n-1 ; i >= 0; i--){
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(max, temp);
        }
        return arr;
    }
}
