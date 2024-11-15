package Leetcode.BinarySearch;

// https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/?envType=daily-question&envId=2024-11-14

public class _2064_minimized_max_of_prod_distribute {

    // TC : O(log max * n)
    // SC : O(1)
    public int minimizedMaximum(int n, int[] q) {
        int max = 0;
        for(int a : q) max = Math.max(max, a);

        int start = 1;
        int end = max;
        int ans = 0;

        // binary search from 1 to max, because either we can store 1 element at each store or we can store the max element at each store
        // if we store 1 element then we will need more stores but if we store max element then we will need len(q) stores, now doing binary seach to find the appropriate mid value where store is equal to the given n
        while(start <= end){
            int mid = end - (end-start) / 2;
            int store = findStore(q, mid);
            if(store <= n){
                end = mid - 1;
                ans = mid;
            }
            else start = mid + 1;
        }
        return ans;
    }

    // this function will give how many minimum stores are required to store all the items of the array if we can store mid number of elements at each store at max
    int findStore(int [] arr, int mid){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % mid == 0) sum += arr[i] / mid;
            else sum += arr[i] / mid + 1;
        }
        return sum;
    }
}
