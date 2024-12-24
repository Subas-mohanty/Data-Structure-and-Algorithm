package Leetcode.Array;

//https://leetcode.com/problems/patching-array/?envType=daily-question&envId=2024-06-16
//https://www.youtube.com/watch?v=Spj4Vz3ZK2A
public class _330_patching_array {
    public int minPatches(int[] nums, int n) {
        int m = nums.length;
        long sum = 0;
        // we are checking from 1 to n, if we can make all the sum or not
        long expectedSum = 1;
        int ans = 0;

        int i = 0;

        while(sum < n){
//            if(sum >= expectedSum) expectedSum = sum + 1; // gives TLE
            if(sum >= expectedSum) expectedSum = sum + 1;
            else{
                // include the elements from the array
                if(i < m && nums[i] <= expectedSum){
                    sum += nums[i];
                    i++;
                }
                // if array elements can't be taken then add a patch or add an element to the array
                else{
                    ans++;
                    sum += expectedSum;
                }
            }
        }
        return ans;
    }
}
