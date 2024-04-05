package Leetcode;


import java.util.Arrays;

public class _68_next_greater_element_2 {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,3};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int [] ans = new int[n];
        int ind = 0;
        for(int i = 0; i< n; i++){
            int greater = findGreater(i, nums);
            ans[ind++] = greater;
        }
        return ans;
    }
    public static int findGreater(int ind, int [] nums){
        int n = nums.length;
        int i;
        for(i = ind; i<n; i++){
            if(nums[i] > nums[ind]){
                return nums[i];
            }
        }
        if(i == n){
            for(int j = 0; j<ind; j++){
                if(nums[j] > nums[ind]){
                    return nums[j];
                }
            }
        }
        return -1;
    }
}
