package Leetcode;

import java.util.*;
//https://leetcode.com/problems/combination-sum-ii/description/
// striver explanation
// https://www.youtube.com/watch?v=G1fRTGRxXU8&t=665s&ab_channel=takeUforward
public class _40_combination_sum_2 {

    // TC : O(2^n * k) --> for recursion + putting list to list of list will take k
    // SC : O(k * x ) --> k is the average length of every combination

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, ans, new ArrayList<>(), 0);

        return ans;
    }
    public void helper(int [] arr, int target, List<List<Integer>> ans, List<Integer> list, int ind){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(ind == arr.length) return;

        for(int i = ind ; i< arr.length; i++){
            // if the i is first time occuring then we can take that otherwise we will loss the value because of the next check and the second check is to ensure no duplicate element is put in the list
      // when we are at i = ind, we can check arr[i] == arr[i-1] , we case will be false, because we there might be two same element at two diff place, but when i > ind, then if two same element i present then we may have taken that previously so we are avoiding it next time
            if(i > ind && arr[i] == arr[i-1]) continue;

            // it is the same take condition in the normal take and not take function
            if(arr[i] <= target){
                list.add(arr[i]);
                helper(arr, target - arr[i], ans, list, i+1);
                list.removeLast();
            }
        }
    }



    // TC : O(2^n * k logn) --> for recursion + set will take log n and putting list to list of list will take k
    // SC : O(2^n + size of set)
    public List<List<Integer>> combinationSum2(int [] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> ans = new HashSet<>(); // storing the values in a set so that it only stores unique values
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        List<List<Integer>> resultList = new ArrayList<>(ans); // converting set of list to list of list
        return resultList;
    }
    private void findCombinations (int ind, int [] arr, int target, Set<List<Integer>> ans, List<Integer> ds) {
        if(ind == arr.length) {
            if(target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        /// we are doing the take and not take operation
        if(arr[ind]<=target) {
            ds.add(arr[ind]);
            findCombinations(ind+1, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size()-1);
        }
        findCombinations(ind +1, arr, target, ans, ds);
    }
}
