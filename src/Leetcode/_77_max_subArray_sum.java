package Leetcode;
//https://leetcode.com/problems/maximum-subarray/
public class _77_max_subArray_sum {
    public static void main(String[] args) {
        int [] nums = {1};
        System.out.println(maxiMumSubArraySum(nums));
        System.out.println(helper2(nums));
        System.out.println(helper3(nums));
    }
    public static int maxiMumSubArraySum(int[] nums) {
        int maxSum = (int) -1e9;
        int sum = (int) -1e9;
        return helper(nums);
    }

    // kadane's algorithm
    // TC : O(n)
    // SC : O(1)
    public static int helper3(int [] nums){
        int maxSum = Integer.MIN_VALUE;
        int sum= 0;

        for (int i = 0; i < nums.length; i++) {
           sum += nums[i];
           maxSum = Math.max(sum, maxSum);
           if(sum < 0) sum = 0;
        }
        return maxSum;
    }

    // TC : O(n^2)
    // SC : O(1)
    public static int helper2(int [] nums){
        int ans = (int) -1e9;
        for(int i = 0; i<nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum+=nums[j];
                ans = Math.max(sum, ans);
            }
        }
        return ans;
    }

    // brute force
    // TC : O(n^3)
    // SC : O(1)
    public static int helper(int [] nums){
        int ans = (int) -1e9;
        for(int i = 0; i<nums.length; i++){
            for(int j = i; j < nums.length; j++){

                int sum = 0;
                for(int k = i; k<=j; k++){
                    sum+=nums[k];
                    ans = Math.max(sum, ans);
                }
            }
        }
        return ans;
    }

}
