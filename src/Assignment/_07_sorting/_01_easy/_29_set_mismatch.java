package Assignment._07_sorting._01_easy;

import java.util.Arrays;
//https://leetcode.com/problems/set-mismatch/

public class _29_set_mismatch {
    public static void main(String[] args) {
        int [] arr={1,1};
        int [] ans=findErrorNums(arr);
        System.out.println(Arrays.toString(ans));
    }
    static int [] findErrorNums(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correctIndex=nums[i]-1;
            if(nums[i]!=nums[correctIndex]){
                swap(nums,i,nums[i]-1);
            } else{
                i++;
            }
        }
        int [] ans=new int[2];
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]!=j+1){
                ans[0]=(nums[j]);
                ans[1]=(j+1);

                // or here we can return new int[] {nums[j],j+1}; by which we don't have to create an array and put the elements there
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
