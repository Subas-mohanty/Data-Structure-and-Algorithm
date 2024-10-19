package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/description/?envType=daily-question&envId=2024-10-18

public class _2044_count_no_of_max_OR_subsets {
    public static void main(String[] args) {
        int [] arr = {2,2,2};
        System.out.println(countMaxOrSubsets(arr));
    }

    // memoization
    // TC : O(n * max)
    public int countMaxOrSubsets3(int [] nums){
        int max = 0;
        for(int a : nums) max |= a;
        Integer [][] dp = new Integer[nums.length][max + 1];

        return helper(0, nums, 0, max, dp);
    }
    public int helper(int ind, int [] nums, int currOr, int max, Integer [][] dp){
        if(ind == nums.length) return currOr == max ? 1 : 0;

        if(dp[ind][currOr] != null) return dp[ind][currOr];

        int take = helper(ind + 1, nums, currOr | nums[ind], max, dp);
        int not = helper(ind + 1, nums, currOr, max, dp);
        return dp[ind][currOr] = take + not;
    }

    // TC : O(2^n + n)
    public int countMaxOrSubsets2(int [] nums){
        int max = 0;
        for(int a : nums) max |= a;
        return helper(0, nums, 0, max);
    }
    public int helper(int ind, int [] nums, int currOr, int max){
        if(ind == nums.length) return currOr == max ? 1 : 0;
        int take = helper(ind + 1, nums, currOr | nums[ind], max);
        int not = helper(ind + 1, nums, currOr, max);
        return take + not;
    }


    // TC : O(n + s * t + n * 2^n)
    public static int countMaxOrSubsets(int[] nums) {
        int max = 0;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums, list, temp, 0);
        System.out.println(list);

        // finding the max bitwise or between all subsets
//        for(List<Integer> subsets : list){
//            if(subsets.isEmpty()) continue;
//            int or = 0;
//            for(int a : subsets){
//                or |= a;
//                max = Math.max(max, or);
//            }
//        }
        // this will also find the max bitwise or, because The maximum bitwise-OR is the bitwise-OR of the whole array.
        // finding the maximum bitwise OR
        // O(n)
        for(int a : nums){
            max |= a;
        }

        // checking how many subsets has bitwise OR == max
        // O(s * t) --> s = no of subsets and t = elements in each subset
        int count = 0;
        for(List<Integer> subsets : list){
            if(subsets.isEmpty()) continue;
            int or = 0;
            for(int a : subsets){
                or |= a;
            }
            if(or == max) count++;
        }
        return count;
    }
    // find all subsets
    // O(n * 2^n)
    public static void helper(int[] nums, List<List<Integer>> list, List<Integer> temp, int ind){
        if(ind == nums.length){
            list.add(new ArrayList<>(temp));
            return;
        }
        helper(nums, list, temp, ind+1); // not take
        temp.add(nums[ind]); // taking the value
        helper(nums, list, temp, ind+1);
        temp.removeLast(); // backtrack to remove the value
    }
}
