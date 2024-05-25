package Leetcode;

import java.util.Arrays;
import java.util.HashSet;

//https://leetcode.com/problems/longest-consecutive-sequence/description/
//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
public class _128_longest_consecutive_sequence {
    public static void main(String[] args) {
        int [] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive2(nums));
    }
    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int ans = 1;
        int count = 1;
        for(int i = 1; i< nums.length; i++){
            while(i < nums.length && nums[i] == nums[i-1]) i++;
            if(i == nums.length) break;
            if(nums[i] == nums[i-1] + 1){
                count++;
                ans = Math.max(count, ans);
            }
            else{
                count = 1;
            }
        }
        return ans;
    }
    public static int longestConsecutive2(int[] nums) {
        if(nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        int ans = 0;

        for(int num : nums) set.add(num);

        for(int num : nums){
            int count = 1;
            int curr = num;

            // for current num count the decreasing consecutive elements
            while(set.contains(--curr)){
                count++;
                set.remove(curr);
            }

            curr = num;
            // for current num count the increasing consecutive elements
            while(set.contains(++curr)){
                count++;
                set.remove(curr);
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
