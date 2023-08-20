package Assignment._07_sorting._02_medium;

import java.util.Arrays;

//https://leetcode.com/problems/find-the-duplicate-number/description/
public class _11_duplicate_number {
    public static void main(String[] args) {
        int [] arr={1,2,3,2,4};
        int ans=findDuplicate(arr);
        System.out.println(ans);
//        findDuplicate(arr);
//        System.out.println(Arrays.toString(arr));
    }

    // cycle sort
    static int findDuplicate(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct=nums[i]-1;
            if(nums[i]!=nums[correct]){
                swap(nums,i,nums[i]-1);
            }
            else{
                i++;
            }
        }
        // for finding the duplicate elements
        int ans=0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]!=j+1){
                ans=nums[j];
            }
        }
        return ans;
    }

    static void swap(int[] nums, int first, int second) {
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }
}
