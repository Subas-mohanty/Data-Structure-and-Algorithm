package Leetcode.BinarySearch;

import java.util.Arrays;
//https://leetcode.com/problems/most-beautiful-item-for-each-query/description/?envType=daily-question&envId=2024-11-12

public class _2070_most_beautiful_item {
    // TC : O(n log n + q + q * log n) --> q = queries.length and n = items.length
    // SC : O(n) --> for the ans array
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = queries.length;
        int m = items.length;
        int [] ans = new int[n];

        // sorting the items array based or price in increasing order
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        // doing something like this in the below loop
        // [[1,2], [2,3], [2,4], [3,2], [4,5]] --> [[1,2], [2,3], [2,4], [3,4], [4,5]] storing the max beauty for each element so when we do binary search on the array we don't have to iterate to get the max again, we can directly get the max in constant time
        int max = 0;
        for(int i = 0; i < m; i++){
            max = Math.max(max, items[i][1]);
            items[i][1] = max;
        }

        for(int i = 0; i < n; i++){
            // finding the floor of each query value and taking the beauty, it will make sure we are getting the max beauty for price less than or equal to the current query, because we have already stored in the increasing order above
            int res = floor(items, queries[i]);
            ans[i] = res;
        }
        return ans;
    }
    // simple binary search to get the floor of a number
    int floor(int [][] arr, int target){
        int l = 0;
        int r = arr.length-1;
        int ans = 0;
        while(l <= r){
            int mid = (l + r) / 2;
            if(arr[mid][0] > target) r = mid - 1;
            else {
                ans = arr[mid][1];
                l = mid+1;
            }
        }
        return ans;
    }
}
