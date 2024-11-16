package Leetcode.Two_pointers;

// https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/?envType=daily-question&envId=2024-11-15


public class _1574_shortest_subarray_to_remove_to_make_array_sorted {

    // TC : O(n)
    // SC : O(1)
    public int findLengthOfShortestSubarray(int[] arr) {

        int n = arr.length;
        int j = n-1;
        // finding the jth index from where to the end the array is sorted
        while(j > 0 && arr[j] >= arr[j-1]) j--;

        // initializing the answer to j, because at least we get the elements sorted from j to end so we have to removed elements from start of the array to jth index
        int ans = j;
        int i = 0;

        // when elements at ith index are increasing and they are less than or equal to arr[j], move the window to get the max length
        while(i < j && (i==0 || arr[i] >= arr[i - 1])){
            // moving j to end to find if any other sorted sequence is present or not
            while(j < n && arr[i] > arr[j]){
                j++;
            }
            ans = Math.min(ans, j - i - 1);
            i++;
        }

        return ans;
    }
}
