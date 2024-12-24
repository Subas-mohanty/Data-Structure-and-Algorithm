package Leetcode.Array;

//https://leetcode.com/problems/relative-sort-array/description/?envType=daily-question&envId=2024-06-11

public class _1122_relative_sorted_array {

    // intution : count sort
    // TC : O(n)
    // SC : O(n log n + arr2.length)
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 0;
        int n = arr1.length;
        int m = arr2.length;
        for(int x : arr1) max = Math.max(x, max); // max element of the array

        // creating the frequency array
        int [] count = new int[max+1];
        for(int i = 0; i < n; i++){
            count[arr1[i]]++;
        }

        int [] ans = new int[n]; // answer array
        int ind = 0;
        for(int i = 0; i < m; i++){
            // when count of element of arr2, we are adding it to the answer array
            while(count[arr2[i]] > 0){
                ans[ind] = arr2[i];
                ind++;
                count[arr2[i]]--;
            }
        }

        // adding the remaining element to the answer array
        for(int i = 0; i < count.length; i++){
            while(count[i] > 0){
                ans[ind] = i;
                ind++;
                count[i]--;
            }
        }
        return ans;
    }
}
