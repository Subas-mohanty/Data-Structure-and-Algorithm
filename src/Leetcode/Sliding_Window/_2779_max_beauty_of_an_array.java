package Leetcode.Sliding_Window;

import java.util.Arrays;
//https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/description/?envType=daily-question&envId=2024-12-11

public class _2779_max_beauty_of_an_array {
    // TC : O(n + n log n) --> for sliding window and sorting
    // SC : O(1)
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        // after sorting the array the problem becomes find the longest sub array from arr[i...j] where arr[j] - arr[i] <= 2 * k
        // why this ?
        // we have the option to subtract k from arr[i] and add k to arr[j] so this becomes, arr[i] - k and arr[j] + k
        // which makes the difference between them is 2 * k, so their diff should be less than or equal to 2*k to be fit in a group
        int i = 0;
        int j = 1;
        int n = nums.length;
        if(n == 1) return 1; // only one element means this will be the answer
        int ans = 0;
        while(j < n){
            // if condition is true, increase j
            while(j < n && nums[j] - nums[i] <= 2*k) j++;
            ans = Math.max(ans, j - i); // condition break, get the answer and then shrink the window
            i++;
        }
        return ans;
    }
}
