
/**
    author : subas
    date : 14-09-2024
*/

package Leetcode.Array;



// https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/?envType=daily-question&envId=2024-09-14

// What are we doing in this quesiton ?
// The quesiton asks to find the longest subarray which has the maximum AND result
// Our first intution will be this can be solved using sliding window but this is wrong, this can't be solved using sliding window. It will use a simple observation
// and that is , the AND of any two number is less than the max of the two numbers, so let's take an example and understand it better
// arr = [1,2,3,4], in this array we can take any two numbers or any range the AND will be less than 4, but if we take only 4 and AND will be 4 , and this is the case for all array, so the answer will always be the largest element in the array, this means we can return 1 always ? No, because the quesiton asks to find the length of the maximum AND, and there might be cases like this arr = [1,2,3,4,4,4], in this case the ans will be 3, because AND of three 4s will be 4, so we have to find longest consecutive length of the maximum element of nums.
// And that is what we are doing here


public class _2419_longest_subarray_with_max_AND {
    

    // TC : O(n + n)
    // SC : O(1)
    public int longestSubarray(int[] nums) {
        int max = 0;
        for(int a : nums) max = Math.max(max, a);

        int ind = 0;
        int n = nums.length;
        int ans = 0;
        while(ind < n){
            int count = 0; 
            while(ind < n && nums[ind] == max){
                count++;
                ind++;
            }
            ans = Math.max(ans, count);
            ind++;
        }
        return ans;
    }
}
