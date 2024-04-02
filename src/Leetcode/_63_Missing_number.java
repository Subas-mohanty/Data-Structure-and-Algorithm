package Leetcode;

//https://leetcode.com/problems/missing-number/description/

public class _63_Missing_number {
    public static void main(String[] args) {

    }
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int toBeSum = n * (n+1)/2;

        if(sum == toBeSum - n) return n;

        return toBeSum - sum;
    }
    public int helper(int[] nums) {
        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            res += i - nums[i];
        }

        return res;
    }
}
