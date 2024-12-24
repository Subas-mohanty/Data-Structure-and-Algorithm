package Leetcode.Array;

// https://leetcode.com/problems/3sum/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3sum {
    public static void main(String[] args) {
        int [] nums ={-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> ans = threeSum(nums);
        for(List<Integer> list: ans){
            System.out.println(list);
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int j=i+1;
            int k=n-1;
            while(j<k) {
                int sumRem = 0 - nums[i];
                if (nums[j] + nums[k] > sumRem) {
                    k--;
                }
                else if(nums[j] + nums[k] < sumRem) {
                    j++;
                }
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    // this is skipping j and k, normally it is doing j++. and in the while loop it is making sure that the next element is not equal to the current j element
                    while (j<k && nums[j]==list.get(1)) j++;
                    while(j<k && nums[k]==list.get(2)) k--;
                }
            }
            while (i < n - 1 && nums[i] == nums[i+1]) i++;
        }
        return ans;
    }
}
