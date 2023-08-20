package Assignment._07_sorting._02_medium;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/find-all-duplicates-in-an-array/
public class _12_find_all_duplicates {
    public static void main(String[] args) {
        int [] arr={1};
        List<Integer> ans=findDuplicates(arr);
        System.out.println(ans);
    }
    static List<Integer> findDuplicates(int[] nums) {
        int i=0;
        while(i< nums.length){
            int correct=nums[i]-1;
            if(nums[i]!=nums[correct]){
                swap(nums,i,nums[i]-1);
            }else{
                i++;
            }
        }
        List<Integer> ans=new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]!=j+1){
                ans.add(nums[j]);
            }
        }
        return ans;
    }

    static void swap(int[] arr, int first, int second) {
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
