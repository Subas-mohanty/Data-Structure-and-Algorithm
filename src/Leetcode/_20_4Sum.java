package Leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/4sum/
public class _20_4Sum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result= new ArrayList<>();
        if(nums==null || nums.length==0){
            return result;
        }
        Arrays.sort(nums);
        int length=nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                long target2 = target - (long)nums[i] - (long)nums[j];
                int start=j+1;
                int end=length-1;
                // binary search between start and end
                while(start<end){
                    // start and end may exceed the integer range if the number is bigger, so we are using long for that
                    long twoSum = (long)nums[start] + (long)nums[end];
                    if(twoSum<target2) start++;
                    else if (twoSum>target2) end--;
                    // we found the target
                    else{
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        result.add(list);

                        while (start<end && nums[start]==list.get(2)) start++;
                        while(start<end && nums[end]==list.get(3)) end--;
                    }
                }
                // for avoiding the duplicates in i and j
                while(j<length-1 && nums[j]==nums[j+1]) j++;
                while (i < length - 1 && nums[i] == nums[i+1]) i++;
            }
        }
        return result;
    }
    // Threesum
    public static List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result= new ArrayList<>();
        int length=nums.length;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                int target2=target-(nums[i]+nums[j]);
                int start=j+1;
                int end=length-1;
                while(start<end){
                    int mid=(start+end)/2;
                    if(target2<nums[mid]) end=mid;
                    else if(target2>nums[mid]) start=mid+1;
                    else{
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[mid]);
                        result.add(list);
                        while(start<end && nums[start]==list.get(2)) start++;
                    }
                }
                while(j<length-1 && nums[j]==nums[j+1]) j++;
                while (i < length - 1 && nums[i] == nums[i+1]) i++;
            }
        }
        return result;
    }
}
