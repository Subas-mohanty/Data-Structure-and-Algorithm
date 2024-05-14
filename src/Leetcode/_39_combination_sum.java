package Leetcode;

import java.util.*;

//https://leetcode.com/problems/combination-sum/submissions/1257916108/

public class _39_combination_sum {
    public static void main(String[] args) {

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }
    public void helper(int [] arr, int target, List<List<Integer>> ans, List<Integer> list, int ind){
        if(ind == arr.length || target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        helper(arr, target, ans, list, ind + 1);
        if(arr[ind] <= target){
            list.add(arr[ind]);
            helper(arr, target - arr[ind], ans, list, ind+1);
            list.removeLast();
        }
    }
}
