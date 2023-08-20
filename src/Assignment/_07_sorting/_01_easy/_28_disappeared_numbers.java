package Assignment._07_sorting._01_easy;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class _28_disappeared_numbers {
    public static void main(String[] args) {
        int [] arr={4,3,2,7,8,2,3,1};
        List ans=disappearedNumbers(arr);
        System.out.println(ans);

    }
    static List disappearedNumbers(int[] nums) {
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

        // for the missing numbers
        List<Integer> ans=new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]!=j+1){ //
                 ans.add(j+1);
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
